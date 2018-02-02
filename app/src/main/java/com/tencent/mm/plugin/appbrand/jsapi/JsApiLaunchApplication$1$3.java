package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.LaunchApplicationTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiLaunchApplication$1$3 implements Runnable {
    final /* synthetic */ 1 jdi;
    final /* synthetic */ LaunchApplicationTask jdl;

    JsApiLaunchApplication$1$3(1 1, LaunchApplicationTask launchApplicationTask) {
        this.jdi = 1;
        this.jdl = launchApplicationTask;
    }

    public final void run() {
        x.i("MicroMsg.JsApiLaunchApplication", "callback task.success:%b", Boolean.valueOf(this.jdl.success));
        this.jdl.afj();
        if (this.jdl.success) {
            this.jdi.iZy.E(this.jdi.gOK, this.jdi.jdh.e("ok", null));
        } else {
            this.jdi.iZy.E(this.jdi.gOK, this.jdi.jdh.e("fail:sdk launch fail", null));
        }
    }
}
