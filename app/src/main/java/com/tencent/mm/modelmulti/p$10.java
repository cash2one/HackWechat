package com.tencent.mm.modelmulti;

import com.tencent.mm.sdk.platformtools.x;

class p$10 implements Runnable {
    final /* synthetic */ p hGP;

    p$10(p pVar) {
        this.hGP = pVar;
    }

    public final void run() {
        x.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
        p.h(this.hGP);
    }
}
