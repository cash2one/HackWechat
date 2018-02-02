package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class DynamicGridView$5 implements AnimatorUpdateListener {
    final /* synthetic */ DynamicGridView rRm;

    DynamicGridView$5(DynamicGridView dynamicGridView) {
        this.rRm = dynamicGridView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.rRm.invalidate();
    }
}
