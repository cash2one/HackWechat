package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class m$1 implements AnimatorUpdateListener {
    final /* synthetic */ m vlF;

    m$1(m mVar) {
        this.vlF = mVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        m.a(this.vlF, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        this.vlF.invalidateSelf();
    }
}
