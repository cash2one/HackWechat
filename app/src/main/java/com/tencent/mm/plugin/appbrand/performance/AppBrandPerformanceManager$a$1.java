package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a;
import com.tencent.mm.sdk.platformtools.bh;

class AppBrandPerformanceManager$a$1 implements Runnable {
    final /* synthetic */ a jFU;
    final /* synthetic */ JsApiGetStorageInfoTask jrq;

    AppBrandPerformanceManager$a$1(a aVar, JsApiGetStorageInfoTask jsApiGetStorageInfoTask) {
        this.jFU = aVar;
        this.jrq = jsApiGetStorageInfoTask;
    }

    public final void run() {
        AppBrandPerformanceManager.n(this.jFU.mAppId, 401, bh.bx((long) this.jrq.size));
        this.jrq.afj();
    }
}
