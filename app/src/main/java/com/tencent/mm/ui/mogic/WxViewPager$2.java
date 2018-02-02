package com.tencent.mm.ui.mogic;

import android.view.animation.Interpolator;

class WxViewPager$2 implements Interpolator {
    WxViewPager$2() {
    }

    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
    }
}
