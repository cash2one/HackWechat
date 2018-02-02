package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.sdk.platformtools.ag;

class FaceDetectUI$7 implements Runnable {
    final /* synthetic */ FaceDetectUI mkq;
    final /* synthetic */ Bitmap mkr;

    FaceDetectUI$7(FaceDetectUI faceDetectUI, Bitmap bitmap) {
        this.mkq = faceDetectUI;
        this.mkr = bitmap;
    }

    public final void run() {
        ag.y(new 1(this, n.n(FaceDetectUI.i(this.mkq), this.mkr)));
    }
}
