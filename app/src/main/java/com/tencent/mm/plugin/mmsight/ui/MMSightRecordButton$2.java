package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class MMSightRecordButton$2 extends AnimatorListenerAdapter {
    final /* synthetic */ MMSightRecordButton oBt;
    final /* synthetic */ AnimatorListenerAdapter oBv = null;

    MMSightRecordButton$2(MMSightRecordButton mMSightRecordButton, AnimatorListenerAdapter animatorListenerAdapter) {
        this.oBt = mMSightRecordButton;
    }

    public final void onAnimationStart(Animator animator) {
        MMSightRecordButton.a(this.oBt, true);
        if (this.oBv != null) {
            this.oBv.onAnimationStart(animator);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        MMSightRecordButton.a(this.oBt, false);
        if (this.oBv != null) {
            this.oBv.onAnimationEnd(animator);
        }
    }
}
