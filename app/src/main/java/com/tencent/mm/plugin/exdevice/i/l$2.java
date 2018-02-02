package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.service.p;

class l$2 implements Runnable {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ String hnj;
    final /* synthetic */ l lRm;
    final /* synthetic */ long lRn;
    final /* synthetic */ p lRo;

    l$2(l lVar, long j, int i, int i2, String str, p pVar) {
        this.lRm = lVar;
        this.lRn = j;
        this.fma = i;
        this.fmb = i2;
        this.hnj = str;
        this.lRo = pVar;
    }

    public final void run() {
        l.c(this.lRm).a(this.lRn, this.fma, this.fmb, this.hnj, this.lRo);
    }

    public final String toString() {
        return super.toString() + "|onTaskEnd";
    }
}
