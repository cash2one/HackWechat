package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class SightCaptureUI$15 extends AnimatorListenerAdapter {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$15(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void onAnimationEnd(Animator animator) {
        SightCaptureUI.G(this.oDb).setEnabled(true);
    }

    public final void onAnimationStart(Animator animator) {
        SightCaptureUI.G(this.oDb).setEnabled(false);
    }
}
