package android.support.v4.view;

import android.view.animation.Interpolator;

class ViewPager$2 implements Interpolator {
    ViewPager$2() {
    }

    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
    }
}
