package com.tencent.wcdb.database;

import android.os.Process;
import android.util.Pair;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteSession {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteSession.class.desiredAssertionStatus());
    public static final int TRANSACTION_MODE_DEFERRED = 0;
    public static final int TRANSACTION_MODE_EXCLUSIVE = 2;
    public static final int TRANSACTION_MODE_IMMEDIATE = 1;
    private SQLiteConnection mConnection;
    private int mConnectionFlags;
    private final SQLiteConnectionPool mConnectionPool;
    private int mConnectionUseCount;
    private Transaction mTransactionPool;
    private Transaction mTransactionStack;

    private static final class Transaction {
        public boolean mChildFailed;
        public SQLiteTransactionListener mListener;
        public boolean mMarkedSuccessful;
        public int mMode;
        public Transaction mParent;

        private Transaction() {
        }
    }

    public SQLiteSession(SQLiteConnectionPool sQLiteConnectionPool) {
        if (sQLiteConnectionPool == null) {
            throw new IllegalArgumentException("connectionPool must not be null");
        }
        this.mConnectionPool = sQLiteConnectionPool;
    }

    public final boolean hasTransaction() {
        return this.mTransactionStack != null;
    }

    public final boolean hasNestedTransaction() {
        return (this.mTransactionStack == null || this.mTransactionStack.mParent == null) ? false : true;
    }

    public final boolean hasConnection() {
        return this.mConnection != null;
    }

    public final void beginTransaction(int i, SQLiteTransactionListener sQLiteTransactionListener, int i2, CancellationSignal cancellationSignal) {
        throwIfTransactionMarkedSuccessful();
        beginTransactionUnchecked(i, sQLiteTransactionListener, i2, cancellationSignal);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void beginTransactionUnchecked(int i, SQLiteTransactionListener sQLiteTransactionListener, int i2, CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        if (this.mTransactionStack == null) {
            acquireConnection(null, i2, cancellationSignal);
        }
        try {
            if (this.mTransactionStack == null) {
                switch (i) {
                    case 1:
                        this.mConnection.execute("BEGIN IMMEDIATE;", null, cancellationSignal);
                    case 2:
                        this.mConnection.execute("BEGIN EXCLUSIVE;", null, cancellationSignal);
                    default:
                        this.mConnection.execute("BEGIN;", null, cancellationSignal);
                }
            }
            if (sQLiteTransactionListener != null) {
                sQLiteTransactionListener.onBegin();
            }
            Transaction obtainTransaction = obtainTransaction(i, sQLiteTransactionListener);
            obtainTransaction.mParent = this.mTransactionStack;
            this.mTransactionStack = obtainTransaction;
            if (this.mTransactionStack == null) {
                releaseConnection();
            }
        } catch (RuntimeException e) {
            if (this.mTransactionStack == null) {
                this.mConnection.execute("ROLLBACK;", null, cancellationSignal);
            }
            throw e;
        } catch (Throwable th) {
            if (this.mTransactionStack == null) {
                releaseConnection();
            }
        }
    }

    public final void setTransactionSuccessful() {
        throwIfNoTransaction();
        throwIfTransactionMarkedSuccessful();
        this.mTransactionStack.mMarkedSuccessful = true;
    }

    public final void endTransaction(CancellationSignal cancellationSignal) {
        throwIfNoTransaction();
        if ($assertionsDisabled || this.mConnection != null) {
            endTransactionUnchecked(cancellationSignal, false);
            return;
        }
        throw new AssertionError();
    }

    private void endTransactionUnchecked(CancellationSignal cancellationSignal, boolean z) {
        RuntimeException runtimeException;
        boolean z2 = false;
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Transaction transaction = this.mTransactionStack;
        boolean z3 = (transaction.mMarkedSuccessful || z) && !transaction.mChildFailed;
        SQLiteTransactionListener sQLiteTransactionListener = transaction.mListener;
        if (sQLiteTransactionListener == null) {
            z2 = z3;
            runtimeException = null;
        } else if (z3) {
            try {
                sQLiteTransactionListener.onCommit();
                z2 = z3;
                runtimeException = null;
            } catch (RuntimeException e) {
                runtimeException = e;
            }
        } else {
            sQLiteTransactionListener.onRollback();
            z2 = z3;
            runtimeException = null;
        }
        this.mTransactionStack = transaction.mParent;
        recycleTransaction(transaction);
        if (this.mTransactionStack == null) {
            if (z2) {
                try {
                    this.mConnection.execute("COMMIT;", null, cancellationSignal);
                } catch (Throwable th) {
                    releaseConnection();
                }
            } else {
                this.mConnection.execute("ROLLBACK;", null, cancellationSignal);
            }
            releaseConnection();
        } else if (!z2) {
            this.mTransactionStack.mChildFailed = true;
        }
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    public final boolean yieldTransaction(long j, boolean z, CancellationSignal cancellationSignal) {
        if (z) {
            throwIfNoTransaction();
            throwIfTransactionMarkedSuccessful();
            throwIfNestedTransaction();
        } else if (this.mTransactionStack == null || this.mTransactionStack.mMarkedSuccessful || this.mTransactionStack.mParent != null) {
            return false;
        }
        if (!$assertionsDisabled && this.mConnection == null) {
            throw new AssertionError();
        } else if (this.mTransactionStack.mChildFailed) {
            return false;
        } else {
            return yieldTransactionUnchecked(j, cancellationSignal);
        }
    }

    private boolean yieldTransactionUnchecked(long j, CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        if (!this.mConnectionPool.shouldYieldConnection(this.mConnection, this.mConnectionFlags)) {
            return false;
        }
        int i = this.mTransactionStack.mMode;
        SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionStack.mListener;
        int i2 = this.mConnectionFlags;
        endTransactionUnchecked(cancellationSignal, true);
        if (j > 0) {
            try {
                Thread.sleep(j);
            } catch (InterruptedException e) {
            }
        }
        beginTransactionUnchecked(i, sQLiteTransactionListener, i2, cancellationSignal);
        return true;
    }

    public final void prepare(String str, int i, CancellationSignal cancellationSignal, SQLiteStatementInfo sQLiteStatementInfo) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        acquireConnection(str, i, cancellationSignal);
        try {
            this.mConnection.prepare(str, sQLiteStatementInfo);
        } finally {
            releaseConnection();
        }
    }

    public final void execute(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (!executeSpecial(str, objArr, i, cancellationSignal)) {
            acquireConnection(str, i, cancellationSignal);
            try {
                this.mConnection.execute(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
            }
        }
    }

    public final long executeForLong(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i, cancellationSignal)) {
            return 0;
        } else {
            acquireConnection(str, i, cancellationSignal);
            try {
                long executeForLong = this.mConnection.executeForLong(str, objArr, cancellationSignal);
                return executeForLong;
            } finally {
                releaseConnection();
            }
        }
    }

    public final String executeForString(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i, cancellationSignal)) {
            return null;
        } else {
            acquireConnection(str, i, cancellationSignal);
            try {
                String executeForString = this.mConnection.executeForString(str, objArr, cancellationSignal);
                return executeForString;
            } finally {
                releaseConnection();
            }
        }
    }

    public final int executeForChangedRowCount(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i, cancellationSignal)) {
            return 0;
        } else {
            acquireConnection(str, i, cancellationSignal);
            try {
                int executeForChangedRowCount = this.mConnection.executeForChangedRowCount(str, objArr, cancellationSignal);
                return executeForChangedRowCount;
            } finally {
                releaseConnection();
            }
        }
    }

    public final long executeForLastInsertedRowId(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (executeSpecial(str, objArr, i, cancellationSignal)) {
            return 0;
        } else {
            acquireConnection(str, i, cancellationSignal);
            try {
                long executeForLastInsertedRowId = this.mConnection.executeForLastInsertedRowId(str, objArr, cancellationSignal);
                return executeForLastInsertedRowId;
            } finally {
                releaseConnection();
            }
        }
    }

    public final int executeForCursorWindow(String str, Object[] objArr, CursorWindow cursorWindow, int i, int i2, boolean z, int i3, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        } else if (cursorWindow == null) {
            throw new IllegalArgumentException("window must not be null.");
        } else if (executeSpecial(str, objArr, i3, cancellationSignal)) {
            cursorWindow.clear();
            return 0;
        } else {
            acquireConnection(str, i3, cancellationSignal);
            try {
                int executeForCursorWindow = this.mConnection.executeForCursorWindow(str, objArr, cursorWindow, i, i2, z, cancellationSignal);
                return executeForCursorWindow;
            } finally {
                releaseConnection();
            }
        }
    }

    public final Pair<Integer, Integer> walCheckpoint(String str, int i) {
        acquireConnection(null, i, null);
        try {
            Pair<Integer, Integer> walCheckpoint = this.mConnection.walCheckpoint(str);
            return walCheckpoint;
        } finally {
            releaseConnection();
        }
    }

    private boolean executeSpecial(String str, Object[] objArr, int i, CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        switch (DatabaseUtils.getSqlStatementType(str)) {
            case 4:
                beginTransaction(2, null, i, cancellationSignal);
                return true;
            case 5:
                setTransactionSuccessful();
                endTransaction(cancellationSignal);
                return true;
            case 6:
                endTransaction(cancellationSignal);
                return true;
            default:
                return false;
        }
    }

    private void acquireConnection(String str, int i, CancellationSignal cancellationSignal) {
        if (this.mConnection == null) {
            this.mConnection = this.mConnectionPool.acquireConnection(str, i, cancellationSignal);
            this.mConnectionFlags = i;
            this.mConnection.setAcquisitionState(Thread.currentThread(), Process.myTid());
        }
        this.mConnectionUseCount++;
    }

    private void releaseConnection() {
        int i = this.mConnectionUseCount - 1;
        this.mConnectionUseCount = i;
        if (i == 0) {
            try {
                this.mConnection.setAcquisitionState(null, 0);
                this.mConnectionPool.releaseConnection(this.mConnection);
            } finally {
                this.mConnection = null;
            }
        }
    }

    final SQLiteConnection acquireConnectionForNativeHandle(int i) {
        acquireConnection(null, i, null);
        return this.mConnection;
    }

    final void releaseConnectionForNativeHandle(Exception exception) {
        if (this.mConnection != null) {
            this.mConnection.endNativeHandle(exception);
        }
        releaseConnection();
    }

    final PreparedStatement acquirePreparedStatement(String str, int i) {
        acquireConnection(str, i, null);
        return this.mConnection.acquirePreparedStatement(str);
    }

    final void releasePreparedStatement(PreparedStatement preparedStatement) {
        if (this.mConnection != null) {
            this.mConnection.releasePreparedStatement(preparedStatement);
            releaseConnection();
        }
    }

    private void throwIfNoTransaction() {
        if (this.mTransactionStack == null) {
            throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
        }
    }

    private void throwIfTransactionMarkedSuccessful() {
        if (this.mTransactionStack != null && this.mTransactionStack.mMarkedSuccessful) {
            throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
        }
    }

    private void throwIfNestedTransaction() {
        if (hasNestedTransaction()) {
            throw new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
        }
    }

    private Transaction obtainTransaction(int i, SQLiteTransactionListener sQLiteTransactionListener) {
        Transaction transaction = this.mTransactionPool;
        if (transaction != null) {
            this.mTransactionPool = transaction.mParent;
            transaction.mParent = null;
            transaction.mMarkedSuccessful = false;
            transaction.mChildFailed = false;
        } else {
            transaction = new Transaction();
        }
        transaction.mMode = i;
        transaction.mListener = sQLiteTransactionListener;
        return transaction;
    }

    private void recycleTransaction(Transaction transaction) {
        transaction.mParent = this.mTransactionPool;
        transaction.mListener = null;
        this.mTransactionPool = transaction;
    }
}
