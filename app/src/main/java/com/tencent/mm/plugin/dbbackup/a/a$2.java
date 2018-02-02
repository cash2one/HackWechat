package com.tencent.mm.plugin.dbbackup.a;

import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.database.SQLiteDatabase;

class a$2 implements DatabaseErrorHandler {
    final /* synthetic */ a lqQ;

    a$2(a aVar) {
        this.lqQ = aVar;
    }

    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
    }
}
