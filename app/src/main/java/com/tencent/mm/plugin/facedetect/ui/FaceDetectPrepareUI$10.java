package com.tencent.mm.plugin.facedetect.ui;

import com.tencent.mm.sdk.platformtools.x;

class FaceDetectPrepareUI$10 implements Runnable {
    final /* synthetic */ FaceDetectPrepareUI mjQ;
    final /* synthetic */ String mjV;

    FaceDetectPrepareUI$10(FaceDetectPrepareUI faceDetectPrepareUI, String str) {
        this.mjQ = faceDetectPrepareUI;
        this.mjV = str;
    }

    public final void run() {
        try {
            FaceDetectPrepareUI.c(this.mjQ).zJ(this.mjV);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", e, "", new Object[0]);
        }
    }
}
