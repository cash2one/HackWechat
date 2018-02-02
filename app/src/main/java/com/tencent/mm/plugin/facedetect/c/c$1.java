package com.tencent.mm.plugin.facedetect.c;

import android.os.Bundle;

class c$1 implements Runnable {
    final /* synthetic */ int fma;
    final /* synthetic */ int fmb;
    final /* synthetic */ String hnj;
    final /* synthetic */ Bundle mfJ;
    final /* synthetic */ c mfK;

    c$1(c cVar, int i, int i2, String str, Bundle bundle) {
        this.mfK = cVar;
        this.fma = i;
        this.fmb = i2;
        this.hnj = str;
        this.mfJ = bundle;
    }

    public final void run() {
        this.mfK.b(this.fma, this.fmb, this.hnj, this.mfJ);
    }
}
