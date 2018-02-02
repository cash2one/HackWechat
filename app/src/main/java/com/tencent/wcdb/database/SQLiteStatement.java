package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteStatement extends SQLiteProgram {
    SQLiteStatement(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) {
        super(sQLiteDatabase, str, objArr, null);
    }

    public final void execute() {
        execute(null);
    }

    public final void execute(CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } catch (Throwable th) {
            releaseReference();
        }
    }

    public final int executeUpdateDelete() {
        return executeUpdateDelete(null);
    }

    public final int executeUpdateDelete(CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            int executeForChangedRowCount = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            return executeForChangedRowCount;
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } catch (Throwable th) {
            releaseReference();
        }
    }

    public final long executeInsert() {
        return executeInsert(null);
    }

    public final long executeInsert(CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            long executeForLastInsertedRowId = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            return executeForLastInsertedRowId;
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } catch (Throwable th) {
            releaseReference();
        }
    }

    public final long simpleQueryForLong() {
        return simpleQueryForLong(null);
    }

    public final long simpleQueryForLong(CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            long executeForLong = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            return executeForLong;
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } catch (Throwable th) {
            releaseReference();
        }
    }

    public final String simpleQueryForString() {
        return simpleQueryForString(null);
    }

    public final String simpleQueryForString(CancellationSignal cancellationSignal) {
        acquireReference();
        try {
            String executeForString = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            return executeForString;
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } catch (Throwable th) {
            releaseReference();
        }
    }

    public final String toString() {
        return "SQLiteProgram: " + getSql();
    }
}
