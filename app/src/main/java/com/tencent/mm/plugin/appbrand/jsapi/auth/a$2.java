package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.c.b;

class a$2 extends b {
    final /* synthetic */ String fgU;
    final /* synthetic */ a jfQ;

    a$2(a aVar, String str) {
        this.jfQ = aVar;
        this.fgU = str;
    }

    public final void onDestroy() {
        a.a(this.jfQ);
        synchronized (a.aao()) {
            a.aao().remove(this.fgU);
        }
    }
}
