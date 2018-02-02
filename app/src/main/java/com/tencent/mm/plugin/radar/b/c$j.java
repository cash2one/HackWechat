package com.tencent.mm.plugin.radar.b;

import com.tencent.mm.storage.x;

final class c$j implements Runnable {
    final /* synthetic */ c pwG;
    final /* synthetic */ x pwU;

    c$j(c cVar, x xVar) {
        this.pwG = cVar;
        this.pwU = xVar;
    }

    public final void run() {
        this.pwG.pwB.I(this.pwU);
    }
}
