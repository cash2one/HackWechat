package com.tencent.mm.plugin.luckymoney.particles;

import android.view.animation.Interpolator;

class e$1 implements Interpolator {
    e$1() {
    }

    public final float getInterpolation(float f) {
        return f >= 0.9f ? 1.0f - ((f - 0.9f) * 10.0f) : 1.0f;
    }
}
