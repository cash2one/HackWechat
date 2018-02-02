package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.q.h.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class j$6 implements a {
    final /* synthetic */ j irY;

    j$6(j jVar) {
        this.irY = jVar;
    }

    public final void po(String str) {
        g.pQN.a(370, 11, 1, false);
    }

    public final void fq(String str) {
        x.e("MicroMsg.AppBrandService", "Inject External Service Script Failed: %s", str);
        g.pQN.a(370, 10, 1, false);
        com.tencent.mm.plugin.appbrand.report.a.z(this.irY.mAppId, 24, 0);
        com.tencent.mm.plugin.appbrand.report.a.a(this.irY.mAppId, this.irY.irP.iqx.iOI.iGL, this.irY.irP.iqx.iOI.iGK, 370, 10);
    }
}
