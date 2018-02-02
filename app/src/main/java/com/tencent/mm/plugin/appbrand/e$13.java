package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.performance.a;
import com.tencent.mm.plugin.appbrand.task.c$a;

class e$13 implements c$a {
    final /* synthetic */ long hAU;
    final /* synthetic */ e irf;

    e$13(e eVar, long j) {
        this.irf = eVar;
        this.hAU = j;
    }

    public final void onReady() {
        this.irf.iqX = true;
        this.irf.iqM.o(2, System.currentTimeMillis() - this.hAU);
        a.a(this.irf.mAppId, "X5Prepare", this.hAU, System.currentTimeMillis());
        this.irf.YC();
    }
}
