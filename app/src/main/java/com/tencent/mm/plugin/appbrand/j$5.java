package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.q.h.a;
import com.tencent.mm.sdk.platformtools.x;

class j$5 implements a {
    final /* synthetic */ j irY;

    j$5(j jVar) {
        this.irY = jVar;
    }

    public final void po(String str) {
        x.i("MicroMsg.AppBrandService", "Inject performanceJs Script Success");
    }

    public final void fq(String str) {
        x.e("MicroMsg.AppBrandService", "Inject performanceJs Script Failed");
    }
}
