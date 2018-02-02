package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;

class c$1 extends b {
    final /* synthetic */ p jdJ;
    final /* synthetic */ c jgI;

    c$1(c cVar, p pVar) {
        this.jgI = cVar;
        this.jdJ = pVar;
    }

    public final void onDestroy() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "AppBrandLifeCycle onDestroy");
        c.b(this.jdJ.mAppId, this);
        this.jgI.afK();
    }
}
