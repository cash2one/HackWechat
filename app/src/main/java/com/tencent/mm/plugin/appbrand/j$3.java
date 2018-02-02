package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.q.h.a;
import com.tencent.mm.sdk.platformtools.x;

class j$3 implements a {
    final /* synthetic */ j irY;

    j$3(j jVar) {
        this.irY = jVar;
    }

    public final void po(String str) {
        x.i("MicroMsg.AppBrandService", "Inject android.js Script Success");
    }

    public final void fq(String str) {
        x.e("MicroMsg.AppBrandService", "Inject android.js Script Failed");
    }
}
