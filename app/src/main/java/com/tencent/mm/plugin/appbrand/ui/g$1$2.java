package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import com.tencent.mm.plugin.appbrand.ui.g.1;

class g$1$2 implements AnimatorUpdateListener {
    final /* synthetic */ 1 jMZ;

    g$1$2(1 1) {
        this.jMZ = 1;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.jMZ.jMY.jKz.setTextColor(Color.argb(Math.round(255.0f * floatValue), 0, 0, 0));
        this.jMZ.jMY.jJq.setAlpha(floatValue);
        this.jMZ.jMY.jKx.setAlpha(floatValue);
        this.jMZ.jMY.jKx.setScaleY(floatValue);
        this.jMZ.jMY.jKx.setScaleX(floatValue);
        this.jMZ.jMY.ak(-1, true);
    }
}
