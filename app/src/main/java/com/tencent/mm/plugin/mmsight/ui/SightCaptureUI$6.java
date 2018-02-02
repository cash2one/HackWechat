package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class SightCaptureUI$6 extends AnimatorListenerAdapter {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$6(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void onAnimationEnd(Animator animator) {
        SightCaptureUI.H(this.oDb).setVisibility(8);
    }
}
