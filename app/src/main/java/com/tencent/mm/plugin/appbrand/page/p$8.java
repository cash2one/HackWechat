package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.performance.a;

class p$8 implements Runnable {
    final /* synthetic */ p jEg;

    p$8(p pVar) {
        this.jEg = pVar;
    }

    public final void run() {
        this.jEg.jEc.ajQ();
        t tVar = this.jEg.jDS;
        tVar.irP.iqM.o(4, System.currentTimeMillis() - tVar.jEZ);
        AppBrandPerformanceManager.a(tVar.mAppId, 203, System.currentTimeMillis() - tVar.jFf);
        a.a(tVar.mAppId, "Native", "PageLoad", tVar.jFf, System.currentTimeMillis(), "");
    }
}
