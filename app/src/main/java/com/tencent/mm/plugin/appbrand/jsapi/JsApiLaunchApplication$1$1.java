package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a.a;
import com.tencent.mm.sdk.platformtools.x;

class JsApiLaunchApplication$1$1 implements a {
    final /* synthetic */ 1 jdi;

    JsApiLaunchApplication$1$1(1 1) {
        this.jdi = 1;
    }

    public final void n(boolean z, boolean z2) {
        x.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z) {
            this.jdi.iZy.E(this.jdi.gOK, this.jdi.jdh.e("ok", null));
        } else {
            this.jdi.iZy.E(this.jdi.gOK, this.jdi.jdh.e("fail:scheme launch fail", null));
        }
    }
}
