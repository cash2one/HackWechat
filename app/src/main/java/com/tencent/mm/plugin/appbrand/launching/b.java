package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class b {
    public static void b(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        appBrandInitConfig.iNX = com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b.aM(appBrandInitConfig.appId, appBrandInitConfig.iGA);
        appBrandInitConfig.abT();
        boolean ao = f.Zm().ao(appBrandInitConfig.username, appBrandInitConfig.iGA);
        if (f.Zn().an(appBrandInitConfig.username, appBrandInitConfig.iGA)) {
            appBrandStatObject.jHc = 1;
        } else if (ao) {
            appBrandStatObject.jHc = 2;
        } else {
            appBrandStatObject.jHc = 3;
        }
    }
}
