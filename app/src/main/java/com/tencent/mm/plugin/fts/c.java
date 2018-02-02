package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.CancellationSignal;
import java.io.File;

public final class c implements g {
    private SQLiteDatabase mJf;
    private SQLiteStatement mJg;
    private SQLiteStatement mJh;
    private SQLiteStatement mJi;

    public c(String str) {
        x.i("MicroMsg.FTS.FTSIndexDB", "Create SearchStorage: %s", new Object[]{str});
        if (this.mJf != null) {
            x.w("MicroMsg.FTS.FTSIndexDB", "before initDB, pre DB is not close, why?");
            this.mJf.close();
        }
        String absolutePath = new File(str, "FTS5IndexMicroMsg.db").getAbsolutePath();
        long currentTimeMillis = System.currentTimeMillis();
        this.mJf = SQLiteDatabase.openOrCreateDatabase(absolutePath, null);
        String yE = q.yE();
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dh();
        byte[] t = com.tencent.mm.a.g.t((yE + ((long) a.Cg())).getBytes());
        SQLiteDatabase sQLiteDatabase = this.mJf;
        long acquireNativeConnectionHandle = sQLiteDatabase.acquireNativeConnectionHandle("initFTS", false, false);
        FTSJNIUtils.nativeInitFts(acquireNativeConnectionHandle, t);
        sQLiteDatabase.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.mJf.rawQuery("PRAGMA journal_mode=WAL;", null).close();
        this.mJf.execSQL("PRAGMA synchronous=NORMAL;");
        this.mJf.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (type INTEGER PRIMARY KEY, version INTEGER);", new Object[]{"FTS5IndexVersion"}));
        this.mJg = this.mJf.compileStatement(String.format("SELECT version FROM %s WHERE type=?;", new Object[]{"FTS5IndexVersion"}));
        this.mJh = this.mJf.compileStatement(String.format("INSERT OR REPLACE INTO %s (type, version) VALUES (?, ?);", new Object[]{"FTS5IndexVersion"}));
        this.mJi = this.mJf.compileStatement(String.format("DELETE FROM %s WHERE type=?", new Object[]{"FTS5IndexVersion"}));
        e.u(18, System.currentTimeMillis() - currentTimeMillis);
        x.i("MicroMsg.FTS.FTSIndexDB", "initDB index params %d %s", new Object[]{Long.valueOf(r4 - currentTimeMillis), bh.fK((long) absolutePath.length())});
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        x.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", new Object[]{str});
        return new a(this.mJf.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, strArr, null));
    }

    public final Cursor a(String str, String[] strArr, CancellationSignal cancellationSignal) {
        x.v("MicroMsg.FTS.FTSIndexDB", "rawQuery: execute sql = %s", new Object[]{str});
        return new a(this.mJf.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, str, null, null, null));
    }

    public final SQLiteStatement compileStatement(String str) {
        x.v("MicroMsg.FTS.FTSIndexDB", "compileStatement sql = %s", new Object[]{str});
        return this.mJf.compileStatement(str);
    }

    public final boolean cB(int i, int i2) {
        int i3;
        if (!AV("FTS5IndexVersion") || this.mJg == null) {
            i3 = 0;
        } else {
            i3 = (int) s((long) i, 0);
        }
        x.i("MicroMsg.FTS.FTSIndexDB", "dbVersion=%d | targetVersion=%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
        if (i3 == i2) {
            return true;
        }
        return false;
    }

    public final long s(long j, long j2) {
        this.mJg.bindLong(1, j);
        try {
            j2 = this.mJg.simpleQueryForLong();
        } catch (SQLiteDoneException e) {
        }
        return j2;
    }

    public final void t(long j, long j2) {
        this.mJh.bindLong(1, j);
        this.mJh.bindLong(2, j2);
        this.mJh.execute();
    }

    public final boolean AV(String str) {
        Cursor rawQuery = this.mJf.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[]{str});
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        return moveToNext;
    }

    public final void execSQL(String str) {
        x.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", new Object[]{str});
        this.mJf.execSQL(str);
    }

    public final void execSQL(String str, Object[] objArr) {
        x.d("MicroMsg.FTS.FTSIndexDB", "execSQL: execute sql = %s", new Object[]{str});
        this.mJf.execSQL(str, objArr);
    }

    public final void close() {
        String str = "MicroMsg.FTS.FTSIndexDB";
        String str2 = "close db:%s isOpen:%b ";
        Object[] objArr = new Object[2];
        objArr[0] = this.mJf;
        objArr[1] = Boolean.valueOf(this.mJf == null ? false : this.mJf.isOpen());
        x.w(str, str2, objArr);
        if (this.mJf != null && this.mJf.isOpen()) {
            x.w("MicroMsg.FTS.FTSIndexDB", "close in trans :%b ", new Object[]{Boolean.valueOf(this.mJf.inTransaction())});
            while (this.mJf.inTransaction()) {
                this.mJf.endTransaction();
            }
            this.mJg.close();
            this.mJh.close();
            this.mJf.close();
            this.mJf = null;
        }
    }

    public final synchronized void beginTransaction() {
        if (!(this.mJf == null || this.mJf.inTransaction())) {
            this.mJf.beginTransaction();
        }
    }

    public final boolean inTransaction() {
        if (this.mJf == null || !this.mJf.inTransaction()) {
            return false;
        }
        return true;
    }

    public final synchronized void commit() {
        if (this.mJf != null && this.mJf.inTransaction()) {
            this.mJf.setTransactionSuccessful();
            this.mJf.endTransaction();
        }
    }

    public final synchronized void rollback() {
        if (this.mJf != null && this.mJf.isOpen() && this.mJf.inTransaction()) {
            x.i("MicroMsg.FTS.FTSIndexDB", "rollback");
            try {
                this.mJf.endTransaction();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSIndexDB", e, "occur error \n%s", new Object[]{e});
            }
        }
    }

    protected static final void aMO() {
        com.tencent.mm.kernel.g.Dk();
        new File(com.tencent.mm.kernel.g.Dj().cachePath, "FTS5IndexMicroMsg.db").delete();
    }

    public static final File aMP() {
        com.tencent.mm.kernel.g.Dk();
        return new File(com.tencent.mm.kernel.g.Dj().cachePath, "FTS5IndexMicroMsg.db");
    }
}
