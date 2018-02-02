package com.tencent.mm.sandbox.updater;

import com.tencent.mm.sdk.platformtools.x;

class f$2 implements Runnable {
    final /* synthetic */ f xde;
    final /* synthetic */ long xdf;

    f$2(f fVar, long j) {
        this.xde = fVar;
        this.xdf = j;
    }

    public final void run() {
        x.d("MicroMsg.TrafficStatistic", "onUpstreamTraffic upstream : %s", Long.valueOf(this.xdf));
        f.a(this.xde, f.a(this.xde) + Math.max(0, this.xdf));
        f.a(this.xde, false);
    }
}
