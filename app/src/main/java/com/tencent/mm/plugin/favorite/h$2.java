package com.tencent.mm.plugin.favorite;

import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.a.d;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.d.h;

class h$2 extends a {
    final /* synthetic */ h mps;

    h$2(h hVar) {
        this.mps = hVar;
    }

    public final boolean execute() {
        h.a(new d());
        h.a(new b());
        return true;
    }

    public final String getName() {
        return "InitFTSFavUIPluginTask";
    }
}
