package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;

class TalkRoomPopupNav$4 implements AnimationListener {
    final /* synthetic */ TalkRoomPopupNav yhD;

    public TalkRoomPopupNav$4(TalkRoomPopupNav talkRoomPopupNav) {
        this.yhD = talkRoomPopupNav;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        TalkRoomPopupNav.c(this.yhD).startAnimation(AnimationUtils.loadAnimation(this.yhD.getContext(), R.a.bpZ));
        TalkRoomPopupNav.c(this.yhD).setVisibility(0);
    }
}
