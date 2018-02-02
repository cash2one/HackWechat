package com.tencent.mm.plugin.favorite.ui.post;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FavPostVoiceUI$8 implements AnimationListener {
    final /* synthetic */ FavPostVoiceUI myN;

    FavPostVoiceUI$8(FavPostVoiceUI favPostVoiceUI) {
        this.myN = favPostVoiceUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        FavPostVoiceUI.l(this.myN).post(new 1(this));
    }
}
