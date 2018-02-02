package com.tencent.mm.d;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.t.a;

class c$3 implements AnimatorUpdateListener {
    final /* synthetic */ c fiO;

    c$3(c cVar) {
        this.fiO = cVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue("bg_alpha")).intValue();
        int intValue2 = ((Integer) valueAnimator.getAnimatedValue("alpha")).intValue();
        c.a(this.fiO);
        a.gl(intValue2);
        c.a(this.fiO);
        a.gm(intValue);
        this.fiO.uS();
    }
}
