package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.f.c;
import com.tencent.mm.plugin.appbrand.f.e;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.m;

class f$7 extends a {
    final /* synthetic */ f iDI;

    f$7(f fVar) {
        this.iDI = fVar;
    }

    public final boolean execute() {
        h cVar = new c();
        ((m) g.k(m.class)).registerIndexStorage(cVar);
        cVar.create();
        j bVar = new b();
        ((m) g.k(m.class)).registerNativeLogic(7, bVar);
        bVar.create();
        com.tencent.mm.plugin.fts.d.h.a(new com.tencent.mm.plugin.appbrand.f.g());
        com.tencent.mm.plugin.fts.d.h.a(new e());
        return true;
    }

    public final String getName() {
        return "InitFTSWeAppPluginTask";
    }
}
