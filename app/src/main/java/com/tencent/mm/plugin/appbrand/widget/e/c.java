package com.tencent.mm.plugin.appbrand.widget.e;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;

public final class c extends e {
    private float kcx;
    private float kcy;

    public c(h hVar, long j, float f, float f2) {
        super(hVar, j);
        this.kcx = f;
        this.kcy = f2;
        this.kcL.play(mk(0));
    }

    protected final ValueAnimator mk(int i) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.kcx, this.kcy});
        ofFloat.setDuration(this.mDuration);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new 1(this));
        return ofFloat;
    }
}
