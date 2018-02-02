package android.support.v7.widget;

import android.view.animation.Interpolator;

class RecyclerView$3 implements Interpolator {
    RecyclerView$3() {
    }

    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
    }
}
