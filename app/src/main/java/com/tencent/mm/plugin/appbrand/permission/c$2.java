package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.plugin.appbrand.c.b;

class c$2 extends b {
    final /* synthetic */ String fgU;
    final /* synthetic */ c jGI;

    c$2(c cVar, String str) {
        this.jGI = cVar;
        this.fgU = str;
    }

    public final void onDestroy() {
        synchronized (c.ajA()) {
            c.ajA().remove(this.fgU);
        }
        c.a(this.jGI);
    }
}
