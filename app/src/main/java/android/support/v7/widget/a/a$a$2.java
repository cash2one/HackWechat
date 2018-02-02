package android.support.v7.widget.a;

import android.view.animation.Interpolator;

class a$a$2 implements Interpolator {
    a$a$2() {
    }

    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
    }
}
