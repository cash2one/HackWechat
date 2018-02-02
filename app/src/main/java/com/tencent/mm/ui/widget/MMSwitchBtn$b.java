package com.tencent.mm.ui.widget;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class MMSwitchBtn$b extends Animation {
    int direction = 0;
    float zvq = 0.0f;
    long zvr = 0;
    final /* synthetic */ MMSwitchBtn zvs;

    public MMSwitchBtn$b(MMSwitchBtn mMSwitchBtn) {
        this.zvs = mMSwitchBtn;
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(new 1(this, mMSwitchBtn));
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        if (this.direction == 0) {
            MMSwitchBtn.d(this.zvs).left = this.zvq - (((float) this.zvr) * f);
        } else {
            MMSwitchBtn.d(this.zvs).left = this.zvq + (((float) this.zvr) * f);
        }
        MMSwitchBtn.e(this.zvs);
        this.zvs.invalidate();
    }
}
