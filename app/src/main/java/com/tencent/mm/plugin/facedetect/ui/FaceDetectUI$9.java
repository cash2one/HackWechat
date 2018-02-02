package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.plugin.facedetect.ui.FaceDetectUI.a;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectUI$9 implements a {
    final /* synthetic */ FaceDetectUI mkq;

    FaceDetectUI$9(FaceDetectUI faceDetectUI) {
        this.mkq = faceDetectUI;
    }

    public final void onFinish() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo set result and return to FaceDetectPrepareUI");
        FaceDetectUI.k(this.mkq);
        this.mkq.b(0, 0, "collect data ok", null);
    }
}
