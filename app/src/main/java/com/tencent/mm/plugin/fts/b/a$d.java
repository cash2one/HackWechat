package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

class a$d extends a {
    private String gAb;
    final /* synthetic */ a mMS;
    private int mNg = 0;

    public a$d(a aVar, String str) {
        this.mMS = aVar;
        this.gAb = str;
    }

    public final boolean execute() {
        x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", new Object[]{this.gAb});
        a.a(this.mMS).a(c.mKi, this.gAb);
        ((PluginFTS) g.k(PluginFTS.class)).getTopHitsLogic().c(c.mKi, this.gAb);
        Cursor Bo = a.a(this.mMS).Bo(this.gAb);
        HashSet hashSet = new HashSet();
        while (Bo.moveToNext()) {
            hashSet.add(Bo.getString(0));
        }
        Bo.close();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!a.b(this.mMS).containsKey(str)) {
                a.b(this.mMS).put(str, a.a(this.mMS).b(c.mKi, str));
                ((PluginFTS) g.k(PluginFTS.class)).getTopHitsLogic().Bm(str);
                this.mNg++;
            }
        }
        return true;
    }

    public final String ado() {
        return String.format("{username: %s mDirtyCount: %d}", new Object[]{this.gAb, Integer.valueOf(this.mNg)});
    }

    public final String getName() {
        return "DeleteContactTask";
    }
}
