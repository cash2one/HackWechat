package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.report.service.g;

class AppBrandPrepareTask$3 implements Runnable {
    final /* synthetic */ AppBrandPrepareTask jwZ;

    AppBrandPrepareTask$3(AppBrandPrepareTask appBrandPrepareTask) {
        this.jwZ = appBrandPrepareTask;
    }

    public final void run() {
        int i = 369;
        if (this.jwZ.jwY) {
            i = 777;
        }
        g.pQN.a((long) i, 3, 1, false);
        a.a(this.jwZ.jwV.mAppId, 0, this.jwZ.jwV.jxk, i, 3);
    }
}
