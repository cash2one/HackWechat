package com.tencent.mm.plugin.facedetect.views;

class FaceDetectView$3 implements Runnable {
    final /* synthetic */ FaceDetectView mmK;

    FaceDetectView$3(FaceDetectView faceDetectView) {
        this.mmK = faceDetectView;
    }

    public final void run() {
        if (FaceDetectView.d(this.mmK) != null && !FaceDetectView.a(this.mmK)) {
            FaceDetectView.d(this.mmK).K(0, "");
        }
    }
}
