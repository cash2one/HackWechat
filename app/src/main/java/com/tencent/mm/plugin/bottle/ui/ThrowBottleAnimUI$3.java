package com.tencent.mm.plugin.bottle.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.R;

class ThrowBottleAnimUI$3 implements AnimationListener {
    final /* synthetic */ ThrowBottleAnimUI kDV;

    ThrowBottleAnimUI$3(ThrowBottleAnimUI throwBottleAnimUI) {
        this.kDV = throwBottleAnimUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        ThrowBottleAnimUI.b(this.kDV).setVisibility(8);
        if (ThrowBottleAnimUI.i(this.kDV) == null) {
            ThrowBottleAnimUI.a(this.kDV, (SprayLayout) ThrowBottleAnimUI.a(this.kDV).findViewById(R.h.bOz));
        }
        ThrowBottleAnimUI.i(this.kDV).G(1, ThrowBottleAnimUI.j(this.kDV), ThrowBottleAnimUI.k(this.kDV));
        ThrowBottleAnimUI.l(this.kDV).sendEmptyMessageDelayed(0, 2000);
    }
}
