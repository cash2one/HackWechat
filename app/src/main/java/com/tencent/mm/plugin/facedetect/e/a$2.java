package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements Runnable {
    final /* synthetic */ a mlr;

    public a$2(a aVar) {
        this.mlr = aVar;
    }

    public final void run() {
        synchronized (a.a(this.mlr)) {
            if (a.n(this.mlr) == a.mlz) {
                x.e("MicroMsg.FaceVideoRecorder", "hy: not started. should not happen");
                a.d(this.mlr);
            } else if (a.n(this.mlr) == a.mlB) {
                x.w("MicroMsg.FaceVideoRecorder", "hy: already started or wait start");
            } else {
                x.i("MicroMsg.FaceVideoRecorder", "hy: startRecord record");
                d.aGr().a(a.o(this.mlr));
                a.g(this.mlr).c(a.k(this.mlr), a.p(this.mlr), a.q(this.mlr));
                a.e(this.mlr, a.mlB);
            }
        }
    }
}
