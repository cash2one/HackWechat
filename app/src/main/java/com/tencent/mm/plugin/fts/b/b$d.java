package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import java.util.List;

class b$d extends a {
    final /* synthetic */ b mNv;
    private String path;

    public b$d(b bVar, String str) {
        this.mNv = bVar;
        this.path = str;
    }

    public final String getName() {
        return "UpdateFeatureIndexTask";
    }

    public final boolean execute() {
        List a = b.a(this.mNv, this.path);
        this.mNv.mNt.beginTransaction();
        this.mNv.mNt.aT(a);
        this.mNv.mNt.commit();
        this.mNv.mNt.h(c.mKc);
        this.mNv.gJk.a(131132, new b$a(this.mNv));
        e topHitsLogic = ((PluginFTS) g.k(PluginFTS.class)).getTopHitsLogic();
        topHitsLogic.mNX.e(c.mKc, 1);
        return true;
    }
}
