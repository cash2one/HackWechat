package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class SightCaptureUI$16 extends AnimatorListenerAdapter {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$16(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void onAnimationEnd(Animator animator) {
        SightCaptureUI.Q(this.oDb).setEnabled(true);
    }

    public final void onAnimationStart(Animator animator) {
        SightCaptureUI.Q(this.oDb).setEnabled(false);
    }
}
