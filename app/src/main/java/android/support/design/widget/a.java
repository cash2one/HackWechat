package android.support.design.widget;

import android.support.v4.view.b.b;
import android.support.v4.view.b.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

final class a {
    static final Interpolator eA = new LinearInterpolator();
    static final Interpolator eB = new b();
    static final Interpolator eC = new android.support.v4.view.b.a();
    static final Interpolator eD = new c();
    static final Interpolator eE = new DecelerateInterpolator();

    static float b(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    static int a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
