package com.tencent.mm.plugin.voip.model.a;

class n$1 implements Runnable {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ String hnj;
    final /* synthetic */ n snW;

    n$1(n nVar, int i, int i2, String str) {
        this.snW = nVar;
        this.fma = i;
        this.fmb = i2;
        this.hnj = str;
    }

    public final void run() {
        if (this.snW.gJT != null) {
            this.snW.gJT.a(this.fma, this.fmb, this.hnj, this.snW);
        }
    }
}
