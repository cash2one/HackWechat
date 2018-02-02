package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.sdk.platformtools.x;

class a$3 extends b {
    final /* synthetic */ j iZy;
    final /* synthetic */ a jvr;

    a$3(a aVar, j jVar) {
        this.jvr = aVar;
        this.iZy = jVar;
    }

    public final void onDestroy() {
        x.d("MicroMsg.JsApiConenctWifi", "remove listener");
        d.a(null);
        c.b(this.iZy.mAppId, this);
    }
}
