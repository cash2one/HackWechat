package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ int mlk;
    final /* synthetic */ int mll;
    final /* synthetic */ int mlm;
    final /* synthetic */ boolean mln = false;
    final /* synthetic */ int mlo = 0;
    final /* synthetic */ int mlp;
    final /* synthetic */ int mlq;
    final /* synthetic */ a mlr;

    public a$1(a aVar, int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        this.mlr = aVar;
        this.mlk = i;
        this.mll = i2;
        this.mlm = i3;
        this.mlp = i5;
        this.mlq = i6;
    }

    public final void run() {
        if (this.mlk == 90 || this.mlk == 270) {
            x.i("MicroMsg.FaceVideoRecorder", "hy: need make width and height upside down");
            a.a(this.mlr, this.mll);
            a.b(this.mlr, this.mlm);
        } else {
            a.a(this.mlr, this.mlm);
            a.b(this.mlr, this.mll);
        }
        synchronized (a.a(this.mlr)) {
            a.c(this.mlr, this.mlk);
            a.a(this.mlr, this.mln);
            a.d(this.mlr, this.mlo);
        }
        a.b(this.mlr);
        a.c(this.mlr);
        a.d(this.mlr);
        ag.y(new 1(this));
    }
}
