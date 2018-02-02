package com.tencent.mm.plugin.appbrand.jsapi;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.plugin.appbrand.page.p;

class bc$3 implements AnimatorUpdateListener {
    final /* synthetic */ p jeh;
    final /* synthetic */ bc jei;

    bc$3(bc bcVar, p pVar) {
        this.jei = bcVar;
        this.jeh = pVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.jeh.i((double) ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
