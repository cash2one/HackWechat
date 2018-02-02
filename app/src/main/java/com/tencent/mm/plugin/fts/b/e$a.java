package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.a;
import java.util.LinkedList;

class e$a extends a {
    int mNZ;
    int mOa;
    final /* synthetic */ e mOb;

    private e$a(e eVar) {
        this.mOb = eVar;
    }

    public final boolean execute() {
        this.mOa = this.mOb.mNX.aNl();
        long currentTimeMillis = System.currentTimeMillis() - 5184000000L;
        com.tencent.mm.plugin.fts.a.a aVar = this.mOb.mNX;
        String format = String.format("SELECT docid FROM %s WHERE timestamp < ? OR score = 0;", new Object[]{aVar.aMR()});
        Cursor rawQuery = aVar.mJR.rawQuery(format, new String[]{String.valueOf(currentTimeMillis)});
        Object linkedList = new LinkedList();
        while (rawQuery.moveToNext()) {
            linkedList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        aVar.aR(linkedList);
        this.mNZ = linkedList.size();
        return true;
    }

    public final String ado() {
        return String.format("{topHitsUpdateCount: %d deleteExpiredCount: %d}", new Object[]{Integer.valueOf(this.mOa), Integer.valueOf(this.mNZ)});
    }

    public final String getName() {
        return "BuildTopHitsIndexTask";
    }
}
