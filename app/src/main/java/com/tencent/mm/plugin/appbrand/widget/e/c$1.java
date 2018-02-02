package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;

class c$1 implements AnimatorUpdateListener {
    final /* synthetic */ c kcz;

    c$1(c cVar) {
        this.kcz = cVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ((h) this.kcz.kcK).setRotation((float) Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue())));
    }
}
