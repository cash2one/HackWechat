package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.launching.c.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

class AppBrandPreInitTask$1 implements a {
    final /* synthetic */ AppBrandPreInitTask jwS;

    AppBrandPreInitTask$1(AppBrandPreInitTask appBrandPreInitTask) {
        this.jwS = appBrandPreInitTask;
    }

    public final void c(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        AppBrandPreInitTask.a(this.jwS, appBrandInitConfig);
        AppBrandPreInitTask.a(this.jwS, appBrandStatObject);
        if (appBrandInitConfig != null) {
            b.b(appBrandInitConfig, appBrandStatObject);
        }
        AppBrandPreInitTask.a(this.jwS);
    }
}
