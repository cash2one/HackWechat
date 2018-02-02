package com.tencent.mm.plugin.appbrand.widget;

import android.support.annotation.Keep;

class CircleProgressDrawable$RingPathTransform {
    public float mF;
    public float mG;
    public float mH;

    private CircleProgressDrawable$RingPathTransform() {
        this.mF = 0.0f;
        this.mG = 0.0f;
        this.mH = 0.0f;
    }

    @Keep
    public void setTrimPathStart(float f) {
        this.mF = f;
    }

    @Keep
    public void setTrimPathEnd(float f) {
        this.mG = f;
    }

    @Keep
    public void setTrimPathOffset(float f) {
        this.mH = f;
    }
}
