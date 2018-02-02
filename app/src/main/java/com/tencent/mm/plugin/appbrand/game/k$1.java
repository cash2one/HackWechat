package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.q.h.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements a {
    final /* synthetic */ k iXI;

    k$1(k kVar) {
        this.iXI = kVar;
    }

    public final void po(String str) {
        x.i("MicroMsg.WAGameWeixinJSContextLogic", "Inject SDK WAGameSubContext Script suc: %s", new Object[]{str});
        g.pQN.a(778, 19, 1, false);
    }

    public final void fq(String str) {
        x.e("MicroMsg.WAGameWeixinJSContextLogic", "Inject SDK WAGameSubContext Script Failed: %s", new Object[]{str});
        g.pQN.a(778, 18, 1, false);
        com.tencent.mm.plugin.appbrand.report.a.z(this.iXI.iXD.irP.mAppId, 24, 0);
        com.tencent.mm.plugin.appbrand.report.a.a(this.iXI.iXD.mAppId, this.iXI.iXD.irP.iqx.iOI.iGL, this.iXI.iXD.irP.iqx.iOI.iGK, 778, 18);
    }
}
