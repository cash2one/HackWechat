package com.tencent.mm.plugin.facedetect.views;

class FaceNumberItemView$1 implements Runnable {
    final /* synthetic */ FaceNumberItemView mmX;

    FaceNumberItemView$1(FaceNumberItemView faceNumberItemView) {
        this.mmX = faceNumberItemView;
    }

    public final void run() {
        if (FaceNumberItemView.a(this.mmX) <= 30) {
            FaceNumberItemView.b(this.mmX);
            this.mmX.invalidate();
            return;
        }
        this.mmX.aHG();
    }
}
