package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.LaunchApplicationTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.a.a;
import com.tencent.mm.sdk.platformtools.x;

class JsApiLaunchApplication$LaunchApplicationTask$1 implements a {
    final /* synthetic */ AppBrandProxyTransparentUIProcessTask.a jdn;
    final /* synthetic */ LaunchApplicationTask jdo;

    JsApiLaunchApplication$LaunchApplicationTask$1(LaunchApplicationTask launchApplicationTask, AppBrandProxyTransparentUIProcessTask.a aVar) {
        this.jdo = launchApplicationTask;
        this.jdn = aVar;
    }

    public final void n(boolean z, boolean z2) {
        x.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z) {
            this.jdo.success = true;
            this.jdn.afh();
            return;
        }
        this.jdo.success = false;
        this.jdn.afh();
    }
}
