package com.tencent.mm.plugin.fav;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.b.a.b;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.m;

class PluginFav$1 extends a {
    final /* synthetic */ PluginFav mnP;

    PluginFav$1(PluginFav pluginFav) {
        this.mnP = pluginFav;
    }

    public final boolean execute() {
        h aVar = new com.tencent.mm.plugin.fav.b.a.a();
        ((m) g.k(m.class)).registerIndexStorage(aVar);
        aVar.create();
        j bVar = new b();
        ((m) g.k(m.class)).registerNativeLogic(6, bVar);
        bVar.create();
        return true;
    }

    public final String getName() {
        return "InitFTSFavPluginTask";
    }
}
