package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.4;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectCameraView$c$4$1 implements Runnable {
    final /* synthetic */ 4 mmm;

    FaceDetectCameraView$c$4$1(4 4) {
        this.mmm = 4;
    }

    public final void run() {
        x.v("MicroMsg.FaceDetectCameraView", "hy: on get preview");
        long Wq = bh.Wq();
        long p = Wq - FaceDetectCameraView.p(this.mmm.mmk.mmc);
        if (FaceDetectCameraView.p(this.mmm.mmk.mmc) >= 0) {
            x.v("MicroMsg.FaceDetectCameraView", "hy: tweenMillis: %d", new Object[]{Long.valueOf(p)});
        }
        if (FaceDetectCameraView.p(this.mmm.mmk.mmc) < 0 || p > FaceDetectCameraView.c(this.mmm.mmk.mmc)) {
            FaceDetectCameraView.a(this.mmm.mmk.mmc, Wq);
            FaceDetectCameraView.b(this.mmm.mmk.mmc, FaceDetectCameraView.o(this.mmm.mmk.mmc));
        }
    }
}
