package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.a;
import java.util.ArrayList;
import java.util.List;

class a$f extends a {
    final /* synthetic */ a mMS;
    private int mNh;
    private int mNi;

    private a$f(a aVar) {
        this.mMS = aVar;
        this.mNh = 0;
        this.mNi = 0;
    }

    public final boolean execute() {
        Cursor rawQuery = a.a(this.mMS).mJR.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
        while (rawQuery.moveToNext()) {
            String string = rawQuery.getString(0);
            long j = rawQuery.getLong(1);
            List list = (List) a.g(this.mMS).get(string);
            if (list == null) {
                list = new ArrayList(16);
                a.g(this.mMS).put(string, list);
                this.mNh++;
            }
            list.add(Long.valueOf(j));
            this.mNi++;
        }
        rawQuery.close();
        return true;
    }

    public final String ado() {
        return String.format("{users: %d labels: %d}", new Object[]{Integer.valueOf(this.mNh), Integer.valueOf(this.mNi)});
    }

    public final String getName() {
        return "LoadLabelCacheTask";
    }
}
