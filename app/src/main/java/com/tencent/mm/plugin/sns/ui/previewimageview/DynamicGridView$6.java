package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class DynamicGridView$6 extends AnimatorListenerAdapter {
    final /* synthetic */ DynamicGridView rRm;

    DynamicGridView$6(DynamicGridView dynamicGridView) {
        this.rRm = dynamicGridView;
    }

    public final void onAnimationStart(Animator animator) {
        DynamicGridView.a(this.rRm, true);
        DynamicGridView.b(this.rRm);
    }

    public final void onAnimationEnd(Animator animator) {
        DynamicGridView.a(this.rRm, false);
        DynamicGridView.b(this.rRm);
    }
}
