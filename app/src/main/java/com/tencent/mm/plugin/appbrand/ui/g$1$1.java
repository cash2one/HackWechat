package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mm.plugin.appbrand.ui.g.1;

class g$1$1 implements AnimatorUpdateListener {
    final /* synthetic */ ViewParent jKE;
    final /* synthetic */ 1 jMZ;

    g$1$1(1 1, ViewParent viewParent) {
        this.jMZ = 1;
        this.jKE = viewParent;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int argb = Color.argb(intValue, 255, 255, 255);
        g.a(this.jMZ.jMY).setBackgroundColor(argb);
        this.jMZ.jMY.ak(argb, true);
        if (intValue == 0) {
            this.jMZ.jMY.setVisibility(8);
            ((ViewGroup) this.jKE).removeView(this.jMZ.jMY);
            try {
                g.b(this.jMZ.jMY).iqC.aiT().aex().aiY();
            } catch (NullPointerException e) {
            }
        }
    }
}
