package com.tencent.mm.plugin.appbrand.game.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class b$4 implements AnimatorUpdateListener {
    int height = b.aed();
    final /* synthetic */ b iYt;

    b$4(b bVar) {
        this.iYt = bVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.iYt.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) this.height));
        this.iYt.requestLayout();
    }
}
