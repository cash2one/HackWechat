package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.q.h.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class d$4 implements a {
    final /* synthetic */ d iXf;

    d$4(d dVar) {
        this.iXf = dVar;
    }

    public final void po(String str) {
        x.i("MicroMsg.WAGameAppService", "Inject SDK WAGame Script suc: %s", new Object[]{str});
        if (this.iXf.irP != null) {
            this.iXf.irP.iqM.o(11, System.currentTimeMillis() - this.iXf.iXd);
        }
        g.pQN.a(778, 15, 1, false);
    }

    public final void fq(String str) {
        x.e("MicroMsg.WAGameAppService", "Inject SDK WAGame Script Failed: %s", new Object[]{str});
        if (this.iXf.irP != null) {
            this.iXf.irP.iqM.o(11, System.currentTimeMillis() - this.iXf.iXd);
        }
        g.pQN.a(778, 14, 1, false);
        com.tencent.mm.plugin.appbrand.report.a.z(this.iXf.mAppId, 24, 0);
        com.tencent.mm.plugin.appbrand.report.a.a(this.iXf.mAppId, this.iXf.irP.iqx.iOI.iGL, this.iXf.irP.iqx.iOI.iGK, 778, 14);
    }
}
