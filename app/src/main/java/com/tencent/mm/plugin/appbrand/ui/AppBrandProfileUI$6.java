package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.sdk.platformtools.ag;

class AppBrandProfileUI$6 implements Runnable {
    final /* synthetic */ boolean jLB;
    final /* synthetic */ AppBrandProfileUI jLy;

    AppBrandProfileUI$6(AppBrandProfileUI appBrandProfileUI, boolean z) {
        this.jLy = appBrandProfileUI;
        this.jLB = z;
    }

    public final void run() {
        ag.y(new 1(this, q.qN(AppBrandProfileUI.d(this.jLy)), q.qM(AppBrandProfileUI.d(this.jLy))));
        if (this.jLB) {
            r.qZ(AppBrandProfileUI.d(this.jLy));
            AppBrandProfileUI.a(this.jLy, 1, 1);
        }
    }
}
