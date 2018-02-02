package com.tencent.mm.plugin.setting.ui.setting;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class UnfamiliarContactDetailUI$12 implements AnimationListener {
    final /* synthetic */ UnfamiliarContactDetailUI qma;

    UnfamiliarContactDetailUI$12(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
        this.qma = unfamiliarContactDetailUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        UnfamiliarContactDetailUI.l(this.qma).setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
