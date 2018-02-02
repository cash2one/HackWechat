package com.tencent.mm.plugin.appbrand.launching.precondition;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.launching.c.a;
import com.tencent.mm.plugin.appbrand.launching.precondition.b.3;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

class b$3$1 implements a {
    final /* synthetic */ 3 jyX;

    b$3$1(3 3) {
        this.jyX = 3;
    }

    public final void c(final AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        if (!this.jyX.jyT.isFinishing()) {
            if (appBrandInitConfig == null) {
                this.jyX.jyT.finish();
                return;
            }
            this.jyX.jyW.b(appBrandInitConfig);
            b.a(this.jyX.jyT, appBrandInitConfig);
            Runnable anonymousClass1 = new Runnable(this) {
                final /* synthetic */ b$3$1 jyY;

                public final void run() {
                    this.jyY.jyX.jyT.d(appBrandInitConfig, this.jyY.jyX.jyW.jyP);
                }
            };
            if (this.jyX.jyT.c(appBrandInitConfig)) {
                b.a(this.jyX.jyT, anonymousClass1);
            } else {
                anonymousClass1.run();
            }
        }
    }
}
