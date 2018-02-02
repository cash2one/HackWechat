package com.tencent.mm.plugin.appbrand.page;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class q$1 implements AnimatorUpdateListener {
    final /* synthetic */ q jEH;

    q$1(q qVar) {
        this.jEH = qVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.jEH.lg((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
