package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandPrepareTask$4 implements Runnable {
    final /* synthetic */ AppBrandPrepareTask jwZ;
    final /* synthetic */ WxaPkgWrappingInfo jxa;

    AppBrandPrepareTask$4(AppBrandPrepareTask appBrandPrepareTask, WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.jwZ = appBrandPrepareTask;
        this.jxa = wxaPkgWrappingInfo;
    }

    public final void run() {
        x.i("MicroMsg.AppBrandPrepareTask", "runInClientProcess, prepare done, appPkg [%d | %s]", new Object[]{Integer.valueOf(this.jxa.iGL), bh.fJ(this.jxa.iGM)});
    }
}
