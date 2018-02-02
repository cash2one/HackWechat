package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.game.a.b;
import com.tencent.mm.plugin.appbrand.game.a.d;
import com.tencent.mm.plugin.appbrand.game.a.f;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.m;

class f$8 extends a {
    final /* synthetic */ f iDI;

    f$8(f fVar) {
        this.iDI = fVar;
    }

    public final boolean execute() {
        h aVar = new com.tencent.mm.plugin.appbrand.game.a.a();
        ((m) g.k(m.class)).registerIndexStorage(aVar);
        aVar.create();
        j bVar = new b();
        ((m) g.k(m.class)).registerNativeLogic(10, bVar);
        bVar.create();
        com.tencent.mm.plugin.fts.d.h.a(new f());
        com.tencent.mm.plugin.fts.d.h.a(new d());
        return true;
    }

    public final String getName() {
        return "InitFTSMiniGamePluginTask";
    }
}
