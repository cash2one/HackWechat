package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

class f$1 implements Runnable {
    final /* synthetic */ e irs;
    final /* synthetic */ AppBrandInitConfig irt;
    final /* synthetic */ AppBrandStatObject iru;
    final /* synthetic */ f irv;

    f$1(f fVar, e eVar, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        this.irv = fVar;
        this.irs = eVar;
        this.irt = appBrandInitConfig;
        this.iru = appBrandStatObject;
    }

    public final void run() {
        this.irv.b(this.irs, this.irt, this.iru);
    }
}
