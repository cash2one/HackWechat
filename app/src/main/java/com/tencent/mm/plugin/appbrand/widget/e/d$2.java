package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;

class d$2 implements AnimatorUpdateListener {
    final /* synthetic */ d kcJ;

    d$2(d dVar) {
        this.kcJ = dVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ((h) this.kcJ.kcK).setRotation((float) Double.parseDouble(String.valueOf(valueAnimator.getAnimatedValue())));
    }
}
