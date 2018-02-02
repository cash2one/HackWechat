package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.q.h.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class d$5 implements a {
    final /* synthetic */ d iXf;

    d$5(d dVar) {
        this.iXf = dVar;
    }

    public final void po(String str) {
        x.i("MicroMsg.WAGameAppService", "Inject SDK game Script suc: %s", str);
        if (this.iXf.irP != null) {
            this.iXf.irP.iqM.o(12, System.currentTimeMillis() - this.iXf.iXe);
        }
        g.pQN.a(778, 27, 1, false);
    }

    public final void fq(String str) {
        x.e("MicroMsg.WAGameAppService", "Inject SDK game Script Failed: %s", str);
        if (this.iXf.irP != null) {
            this.iXf.irP.iqM.o(12, System.currentTimeMillis() - this.iXf.iXe);
        }
        g.pQN.a(778, 26, 1, false);
        com.tencent.mm.plugin.appbrand.report.a.z(this.iXf.mAppId, 24, 0);
        com.tencent.mm.plugin.appbrand.report.a.a(this.iXf.mAppId, this.iXf.irP.iqx.iOI.iGL, this.iXf.irP.iqx.iOI.iGK, 778, 26);
    }
}
