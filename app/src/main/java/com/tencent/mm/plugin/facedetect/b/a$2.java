package com.tencent.mm.plugin.facedetect.b;

class a$2 implements Runnable {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ String hnj;
    final /* synthetic */ a meV;

    a$2(a aVar, int i, int i2, String str) {
        this.meV = aVar;
        this.fma = i;
        this.fmb = i2;
        this.hnj = str;
    }

    public final void run() {
        if (this.meV.meL != null) {
            this.meV.meL.a(this.meV.meP, this.fma, this.fmb, this.hnj);
        }
    }
}
