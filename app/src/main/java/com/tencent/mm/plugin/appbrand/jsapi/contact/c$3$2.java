package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c.3;
import com.tencent.mm.sdk.platformtools.x;

class c$3$2 extends b {
    final /* synthetic */ 3 jiW;

    c$3$2(3 3) {
        this.jiW = 3;
    }

    public final void onDestroy() {
        x.i("MicroMsg.JsApiEnterContact", "onDestroy");
        if (c.jfv > 0) {
            c.jfv--;
            c.f(this.jiW.jiR).irP.YE();
        }
        this.jiW.jiU.afj();
        c.b(c.f(this.jiW.jiR).mAppId, this);
    }
}
