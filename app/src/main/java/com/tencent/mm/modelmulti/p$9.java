package com.tencent.mm.modelmulti;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class p$9 implements Runnable {
    final /* synthetic */ p hGP;

    p$9(p pVar) {
        this.hGP = pVar;
    }

    public final void run() {
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
        p.b(this.hGP);
        p.c(this.hGP);
        p.d(this.hGP);
        p.e(this.hGP);
        p.f(this.hGP);
        ar.Dm();
        ag.K(p.g(this.hGP));
        ar.Dm().g(p.g(this.hGP), 10000);
    }
}
