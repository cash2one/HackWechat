package com.tencent.mm.plugin.facedetect.views;

class FaceDetectCameraView$1 implements Runnable {
    final /* synthetic */ FaceDetectCameraView mmc;

    FaceDetectCameraView$1(FaceDetectCameraView faceDetectCameraView) {
        this.mmc = faceDetectCameraView;
    }

    public final void run() {
        this.mmc.a(FaceDetectCameraView.b(this.mmc), FaceDetectCameraView.c(this.mmc));
        FaceDetectCameraView.a(this.mmc, false);
    }
}
