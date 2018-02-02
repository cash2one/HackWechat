package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.plugin.facedetect.a$h;
import com.tencent.mm.plugin.facedetect.views.c;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectUI$5 implements c {
    final /* synthetic */ FaceDetectUI mkq;

    FaceDetectUI$5(FaceDetectUI faceDetectUI) {
        this.mkq = faceDetectUI;
    }

    public final void pD(int i) {
        x.i("MicroMsg.FaceDetectUI", "alvinluo onPreviewInitDone: %d", Integer.valueOf(i));
        if (i == 0) {
            FaceDetectUI.f(this.mkq);
        } else if (i == 1) {
            FaceDetectUI.g(this.mkq);
        } else if (i == 2) {
            FaceDetectUI.a(this.mkq, "camera permission not granted", this.mkq.getString(a$h.ezM));
        }
    }
}
