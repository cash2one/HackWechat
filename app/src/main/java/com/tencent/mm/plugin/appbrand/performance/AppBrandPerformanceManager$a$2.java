package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.mm.plugin.appbrand.performance.d.a;

class AppBrandPerformanceManager$a$2 implements a {
    final /* synthetic */ AppBrandPerformanceManager.a jFU;

    AppBrandPerformanceManager$a$2(AppBrandPerformanceManager.a aVar) {
        this.jFU = aVar;
    }

    public final void j(double d) {
        if (Math.round(AppBrandPerformanceManager.a.b(this.jFU)) != Math.round(d)) {
            AppBrandPerformanceManager.a.a(this.jFU, d);
            AppBrandPerformanceManager.n(AppBrandPerformanceManager.a.a(this.jFU), 303, Math.round(AppBrandPerformanceManager.a.b(this.jFU)) + " fps");
            a.a(AppBrandPerformanceManager.a.a(this.jFU), "Hardware", "FPS", AppBrandPerformanceManager.a.b(this.jFU));
        }
    }
}
