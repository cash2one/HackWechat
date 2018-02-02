package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class DynamicGridView$10 extends AnimatorListenerAdapter {
    final /* synthetic */ DynamicGridView rRm;

    DynamicGridView$10(DynamicGridView dynamicGridView) {
        this.rRm = dynamicGridView;
    }

    public final void onAnimationStart(Animator animator) {
        DynamicGridView.b(this.rRm, true);
        DynamicGridView.b(this.rRm);
    }

    public final void onAnimationEnd(Animator animator) {
        DynamicGridView.b(this.rRm, false);
        DynamicGridView.b(this.rRm);
    }
}
