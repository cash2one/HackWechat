package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.a;

class GestureGuardLogicUI$15 implements AnimationListener {
    final /* synthetic */ GestureGuardLogicUI tgm;
    final /* synthetic */ a tgp;

    GestureGuardLogicUI$15(GestureGuardLogicUI gestureGuardLogicUI, a aVar) {
        this.tgm = gestureGuardLogicUI;
        this.tgp = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        GestureGuardLogicUI.q(this.tgm).setAnimationListener(null);
        if (this.tgp != null) {
            this.tgp.onDone();
        }
    }
}
