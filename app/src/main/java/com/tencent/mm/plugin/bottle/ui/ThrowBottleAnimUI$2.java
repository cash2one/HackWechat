package com.tencent.mm.plugin.bottle.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ThrowBottleAnimUI$2 implements AnimationListener {
    final /* synthetic */ ThrowBottleAnimUI kDV;

    ThrowBottleAnimUI$2(ThrowBottleAnimUI throwBottleAnimUI) {
        this.kDV = throwBottleAnimUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        ThrowBottleAnimUI.c(this.kDV).setVisibility(8);
        ThrowBottleAnimUI.h(this.kDV);
    }
}
