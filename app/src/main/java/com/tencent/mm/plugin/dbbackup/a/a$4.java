package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import com.tencent.mm.plugin.dbbackup.a.a.c;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.HashMap;

class a$4 implements c {
    final /* synthetic */ a lqQ;
    final /* synthetic */ HashMap lqT;
    final /* synthetic */ int lqU;

    a$4(a aVar, int i, HashMap hashMap) {
        this.lqQ = aVar;
        this.lqU = i;
        this.lqT = hashMap;
    }

    public final boolean a(Cursor cursor, SQLiteStatement sQLiteStatement) {
        Long l = (Long) this.lqT.get(Long.valueOf(cursor.getLong(this.lqU)));
        if (l != null) {
            sQLiteStatement.bindLong(this.lqU + 1, l.longValue());
        }
        return true;
    }
}
