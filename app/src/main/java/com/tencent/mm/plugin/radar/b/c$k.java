package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.storage.x;

final class c$k implements Runnable {
    final /* synthetic */ c pwG;
    final /* synthetic */ x pwU;

    c$k(c cVar, x xVar) {
        this.pwG = cVar;
        this.pwU = xVar;
    }

    public final void run() {
        this.pwG.pwB.J(this.pwU);
    }
}
