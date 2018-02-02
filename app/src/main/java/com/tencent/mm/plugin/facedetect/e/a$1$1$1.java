package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.e.a.1.1;
import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$1$1$1 implements Runnable {
    final /* synthetic */ long mlt;
    final /* synthetic */ 1 mlu;

    a$1$1$1(1 1, long j) {
        this.mlu = 1;
        this.mlt = j;
    }

    public final void run() {
        synchronized (a.a(this.mlu.mls.mlr)) {
            x.i("MicroMsg.FaceVideoRecorder", "hy: connect cost %s ms", Long.valueOf(bh.bA(this.mlt)));
            long Wq = bh.Wq();
            a.a(this.mlu.mls.mlr, a.e(this.mlu.mls.mlr).XX());
            a.g(this.mlu.mls.mlr).setFilePath(a.f(this.mlu.mls.mlr));
            a.g(this.mlu.mls.mlr).Fi(a.h(this.mlu.mls.mlr));
            a.g(this.mlu.mls.mlr).baE();
            a.g(this.mlu.mls.mlr).m(a.i(this.mlu.mls.mlr), a.j(this.mlu.mls.mlr), this.mlu.mls.mlp, this.mlu.mls.mlq);
            a.g(this.mlu.mls.mlr).sN(a.k(this.mlu.mls.mlr));
            a.g(this.mlu.mls.mlr).a(a.l(this.mlu.mls.mlr));
            a.e(this.mlu.mls.mlr, a.mlA);
            x.i("MicroMsg.FaceVideoRecorder", "hy: init in main thread cost %d ms", Long.valueOf(bh.bA(Wq)));
        }
    }
}
