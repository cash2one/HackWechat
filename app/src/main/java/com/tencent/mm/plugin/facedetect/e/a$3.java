package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements Runnable {
    final /* synthetic */ a mlr;

    a$3(a aVar) {
        this.mlr = aVar;
    }

    public final void run() {
        synchronized (a.a(this.mlr)) {
            if (a.n(this.mlr) == a.mlz) {
                x.e("MicroMsg.FaceVideoRecorder", "hy: not started when cancel. should not happen");
                a.d(this.mlr);
                return;
            }
            x.i("MicroMsg.FaceVideoRecorder", "hy: cancel record");
            a.g(this.mlr).cancel();
            a.d(this.mlr);
            d.aGr().b(a.o(this.mlr));
            a.e(this.mlr, a.mlE);
            a.m(this.mlr).release();
        }
    }
}
