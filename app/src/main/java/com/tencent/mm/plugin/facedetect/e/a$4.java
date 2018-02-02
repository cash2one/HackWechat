package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.sdk.platformtools.x;

class a$4 implements Runnable {
    final /* synthetic */ a mlr;
    final /* synthetic */ b mlv;

    a$4(a aVar, b bVar) {
        this.mlr = aVar;
        this.mlv = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        synchronized (a.a(this.mlr)) {
            a.a(this.mlr, this.mlv);
            if (a.n(this.mlr) == a.mlz) {
                x.e("MicroMsg.FaceVideoRecorder", "hy: not initialized. should not happen");
                a.d(this.mlr);
                if (a.r(this.mlr) != null) {
                    a.r(this.mlr).zN(null);
                }
            } else if (a.n(this.mlr) == a.mlE || a.n(this.mlr) == a.mlA) {
                x.w("MicroMsg.FaceVideoRecorder", "hy: cancelled or not started capturing.");
                a.d(this.mlr);
                if (a.r(this.mlr) != null) {
                    a.r(this.mlr).zN(null);
                }
            } else if (a.n(this.mlr) == a.mlD) {
                x.i("MicroMsg.FaceVideoRecorder", "hy: already stopped");
                if (a.r(this.mlr) != null) {
                    a.r(this.mlr).zN(a.g(this.mlr).getFilePath());
                }
            } else if (a.n(this.mlr) == a.mlC) {
                x.i("MicroMsg.FaceVideoRecorder", "hy: stopping. wait");
            } else {
                x.i("MicroMsg.FaceVideoRecorder", "hy: stop record and release");
                d.aGr().b(a.o(this.mlr));
                a.e(this.mlr, a.mlC);
                a.g(this.mlr).C(new 1(this));
            }
        }
    }
}
