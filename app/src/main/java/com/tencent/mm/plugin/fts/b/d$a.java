package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.d;

public class d$a extends a {
    public String mNV;
    final /* synthetic */ d mNW;

    public d$a(d dVar) {
        this.mNW = dVar;
    }

    public final boolean execute() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.mNV);
        stringBuffer.append("​");
        stringBuffer.append(d.am(this.mNV, false));
        stringBuffer.append("​");
        stringBuffer.append(d.am(this.mNV, true));
        com.tencent.mm.plugin.fts.c.d dVar = this.mNW.mNU;
        String str = this.mNV;
        String stringBuffer2 = stringBuffer.toString();
        Cursor rawQuery = dVar.mJR.rawQuery(String.format("SELECT docid FROM %s WHERE history = ?", new Object[]{com.tencent.mm.plugin.fts.c.d.aMR()}), new String[]{str});
        long j = -1;
        if (rawQuery.moveToNext()) {
            j = rawQuery.getLong(0);
        }
        rawQuery.close();
        if (j >= 0) {
            dVar.mOu.bindLong(1, System.currentTimeMillis());
            dVar.mOu.bindLong(2, j);
            dVar.mOu.execute();
        } else {
            if (!dVar.mJR.inTransaction()) {
                dVar.mJR.beginTransaction();
            }
            dVar.mJS.bindString(1, stringBuffer2);
            dVar.mJS.execute();
            dVar.mJT.bindString(1, str);
            dVar.mJT.bindLong(2, System.currentTimeMillis());
            dVar.mJT.execute();
            if (dVar.mJR.inTransaction()) {
                dVar.mJR.commit();
            }
        }
        return true;
    }

    public final String getName() {
        return "AddSOSHistoryTask";
    }
}
