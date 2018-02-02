package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TalkRoomPopupNav$9 implements AnimationListener {
    final /* synthetic */ TalkRoomPopupNav yhD;

    public TalkRoomPopupNav$9(TalkRoomPopupNav talkRoomPopupNav) {
        this.yhD = talkRoomPopupNav;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (TalkRoomPopupNav.h(this.yhD) != null) {
            TalkRoomPopupNav.g(this.yhD).startAnimation(TalkRoomPopupNav.h(this.yhD));
        }
    }
}
