package com.tencent.mm.aq;

import com.tencent.mm.kernel.g;

class i$6 implements Runnable {
    final /* synthetic */ i hBd;
    final /* synthetic */ e hBg;
    final /* synthetic */ int hBh;

    i$6(i iVar, e eVar, int i) {
        this.hBd = iVar;
        this.hBg = eVar;
        this.hBh = i;
    }

    public final void run() {
        g.Di().gPJ.a(new l((int) this.hBg.hzP, this.hBh, (byte) 0), 0);
    }
}
