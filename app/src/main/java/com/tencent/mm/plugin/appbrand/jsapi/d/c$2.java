package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.d.a.a;
import com.tencent.mm.sdk.platformtools.x;

class c$2 extends b {
    final /* synthetic */ j iZy;
    final /* synthetic */ c jjR;

    c$2(c cVar, j jVar) {
        this.jjR = cVar;
        this.iZy = jVar;
    }

    public final void onDestroy() {
        x.i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
        c.b(this.iZy.mAppId, this);
        a sp = a.sp(this.iZy.mAppId);
        if (sp != null) {
            sp.vo();
            a.remove(this.iZy.mAppId);
        }
        this.jjR.jhH = null;
    }
}
