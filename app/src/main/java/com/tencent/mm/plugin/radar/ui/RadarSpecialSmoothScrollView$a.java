package com.tencent.mm.plugin.radar.ui;

import android.view.animation.Interpolator;

final class RadarSpecialSmoothScrollView$a implements Interpolator {
    private static final float pyH = pyH;
    public static final a pyI = new a((byte) 0);
    private final float pyG = pyH;

    public final float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (((f2 * (this.pyG + 1.0f)) + this.pyG) * (f2 * f2)) + 1.0f;
    }
}
