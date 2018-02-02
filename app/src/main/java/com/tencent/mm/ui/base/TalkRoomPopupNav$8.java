package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TalkRoomPopupNav$8 implements AnimationListener {
    final /* synthetic */ TalkRoomPopupNav yhD;

    public TalkRoomPopupNav$8(TalkRoomPopupNav talkRoomPopupNav) {
        this.yhD = talkRoomPopupNav;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (TalkRoomPopupNav.f(this.yhD) != null) {
            TalkRoomPopupNav.g(this.yhD).startAnimation(TalkRoomPopupNav.f(this.yhD));
        }
    }
}
