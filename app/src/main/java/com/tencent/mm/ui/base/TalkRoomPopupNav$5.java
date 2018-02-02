package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TalkRoomPopupNav$5 implements AnimationListener {
    final /* synthetic */ TalkRoomPopupNav yhD;

    public TalkRoomPopupNav$5(TalkRoomPopupNav talkRoomPopupNav) {
        this.yhD = talkRoomPopupNav;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        TalkRoomPopupNav.d(this.yhD).setVisibility(8);
        TalkRoomPopupNav.d(this.yhD).setClickable(false);
    }
}
