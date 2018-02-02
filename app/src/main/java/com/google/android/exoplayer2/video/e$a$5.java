package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.e.a;

class e$a$5 implements Runnable {
    final /* synthetic */ a aEb;
    final /* synthetic */ int aEe;
    final /* synthetic */ int aEf;
    final /* synthetic */ int aEg;
    final /* synthetic */ float aEh;

    e$a$5(a aVar, int i, int i2, int i3, float f) {
        this.aEb = aVar;
        this.aEe = i;
        this.aEf = i2;
        this.aEg = i3;
        this.aEh = f;
    }

    public final void run() {
        this.aEb.aEa.a(this.aEe, this.aEf, this.aEg, this.aEh);
    }
}
