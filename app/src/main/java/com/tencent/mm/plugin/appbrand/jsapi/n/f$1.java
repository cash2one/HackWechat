package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.mm.plugin.appbrand.page.p.c;

class f$1 implements c {
    final /* synthetic */ a jvo;
    final /* synthetic */ f jvp;

    f$1(f fVar, a aVar) {
        this.jvp = fVar;
        this.jvo = aVar;
    }

    public final boolean aeG() {
        a aVar = this.jvo;
        if (aVar.juE.canGoBack()) {
            aVar.ahC().b(aVar.jcr, true);
            aVar.juE.goBack();
            aVar.juJ = true;
            return true;
        }
        aVar.ahC().b(aVar.jcr, false);
        return false;
    }
}
