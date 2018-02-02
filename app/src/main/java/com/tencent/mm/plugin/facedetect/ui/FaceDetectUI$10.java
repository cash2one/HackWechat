package com.tencent.mm.plugin.facedetect.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FaceDetectUI$10 implements AnimationListener {
    final /* synthetic */ FaceDetectUI mkq;

    FaceDetectUI$10(FaceDetectUI faceDetectUI) {
        this.mkq = faceDetectUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        FaceDetectUI.l(this.mkq);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
