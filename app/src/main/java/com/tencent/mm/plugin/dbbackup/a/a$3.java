package com.tencent.mm.plugin.dbbackup.a;

import android.database.Cursor;
import com.tencent.mm.plugin.dbbackup.a.a.c;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.HashMap;

class a$3 implements c {
    final /* synthetic */ a lqQ;
    final /* synthetic */ int lqR;
    final /* synthetic */ long[] lqS;
    final /* synthetic */ HashMap lqT;

    a$3(a aVar, int i, long[] jArr, HashMap hashMap) {
        this.lqQ = aVar;
        this.lqR = i;
        this.lqS = jArr;
        this.lqT = hashMap;
    }

    public final boolean a(Cursor cursor, SQLiteStatement sQLiteStatement) {
        long j = cursor.getLong(this.lqR);
        long[] jArr = this.lqS;
        long j2 = jArr[0];
        jArr[0] = 1 + j2;
        this.lqT.put(Long.valueOf(j), Long.valueOf(j2));
        sQLiteStatement.bindLong(this.lqR + 1, j2);
        if (this.lqS[0] > 1000000 && this.lqS[0] <= 10000000) {
            this.lqS[0] = 10000001;
        }
        return true;
    }
}
