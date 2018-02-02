package com.tencent.mm.booter;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.f;

class o$1 implements Runnable {
    final /* synthetic */ int gyM;

    o$1(int i) {
        this.gyM = i;
    }

    public final void run() {
        g.pQN.k(10675, this.gyM + "," + f.fdS);
    }
}
