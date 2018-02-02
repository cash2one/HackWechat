package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectUI$2 implements Runnable {
    final /* synthetic */ FaceDetectUI mkq;

    FaceDetectUI$2(FaceDetectUI faceDetectUI) {
        this.mkq = faceDetectUI;
    }

    public final void run() {
        long Wq = bh.Wq();
        Runtime.getRuntime().gc();
        x.i("MicroMsg.FaceDetectUI", "hy: gc uses: %d ms", Long.valueOf(bh.bA(Wq)));
    }
}
