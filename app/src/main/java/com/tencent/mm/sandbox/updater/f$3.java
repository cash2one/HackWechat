package com.tencent.mm.sandbox.updater;

import com.tencent.mm.sdk.platformtools.x;

class f$3 implements Runnable {
    final /* synthetic */ f xde;
    final /* synthetic */ long xdg;

    f$3(f fVar, long j) {
        this.xde = fVar;
        this.xdg = j;
    }

    public final void run() {
        x.d("MicroMsg.TrafficStatistic", "onDownstreamTraffic downstream : %s", new Object[]{Long.valueOf(this.xdg)});
        f.b(this.xde, f.b(this.xde) + Math.max(0, this.xdg));
        f.a(this.xde, false);
    }
}
