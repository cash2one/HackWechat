package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TalkRoomPopupNav$6 implements AnimationListener {
    final /* synthetic */ TalkRoomPopupNav yhD;

    TalkRoomPopupNav$6(TalkRoomPopupNav talkRoomPopupNav) {
        this.yhD = talkRoomPopupNav;
    }

    public final void onAnimationStart(Animation animation) {
        TalkRoomPopupNav.c(this.yhD).setVisibility(4);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        TalkRoomPopupNav.e(this.yhD).setVisibility(8);
        TalkRoomPopupNav.d(this.yhD).setClickable(true);
    }
}
