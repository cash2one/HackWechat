package com.tencent.mm.plugin.appbrand.performance;

import android.view.Choreographer.FrameCallback;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a;

class AppBrandPerformanceManager$a$3 extends b {
    final /* synthetic */ a jFU;

    AppBrandPerformanceManager$a$3(a aVar) {
        this.jFU = aVar;
    }

    public final void onDestroy() {
        super.onDestroy();
        a aVar = this.jFU;
        aVar.AW = false;
        c.b(aVar.mAppId, aVar.jFT);
        if (a.ajs() && aVar.jFR != null) {
            FrameCallback frameCallback = aVar.jFR;
            frameCallback.AW = false;
            frameCallback.jGi = 0;
            frameCallback.jGj = 0;
            frameCallback.jGh.removeFrameCallback(frameCallback);
        }
    }

    public final void a(c.c cVar) {
        super.a(cVar);
        a aVar = this.jFU;
        aVar.iqR = true;
        if (a.ajs() && aVar.jFR != null) {
            aVar.jFR.iqR = true;
        }
    }

    public final void onResume() {
        super.onResume();
        a aVar = this.jFU;
        aVar.iqR = false;
        if (a.ajs() && aVar.jFR != null) {
            aVar.jFR.iqR = false;
        }
    }
}
