package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;

class d$2 extends b {
    final /* synthetic */ j iZy;
    final /* synthetic */ d jvv;
    final /* synthetic */ Context jvw;

    d$2(d dVar, Context context, j jVar) {
        this.jvv = dVar;
        this.jvw = context;
        this.iZy = jVar;
    }

    public final void onDestroy() {
        if (d.jvu != null) {
            x.i("MicroMsg.JsApiStartWifi", "unregisterReceiver");
            this.jvw.unregisterReceiver(d.jvu);
            d.jvt = false;
            d.jvu = null;
        }
        c.b(this.iZy.mAppId, this);
    }
}
