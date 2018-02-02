package com.tencent.mm.aq;

import com.tencent.mm.ae.f;

class l$3 implements Runnable {
    final /* synthetic */ int hBA;
    final /* synthetic */ l hBQ;
    final /* synthetic */ f hBy;
    final /* synthetic */ int hBz;

    l$3(l lVar, f fVar, int i, int i2) {
        this.hBQ = lVar;
        this.hBy = fVar;
        this.hBz = i;
        this.hBA = i2;
    }

    public final void run() {
        this.hBy.a(this.hBz, this.hBA, this.hBQ);
    }
}
