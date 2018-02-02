package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FacingCreateChatRoomAllInOneUI$4 implements AnimationListener {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI pmn;

    FacingCreateChatRoomAllInOneUI$4(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        this.pmn = facingCreateChatRoomAllInOneUI;
    }

    public final void onAnimationStart(Animation animation) {
        FacingCreateChatRoomAllInOneUI.k(this.pmn).setVisibility(4);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        FacingCreateChatRoomAllInOneUI.l(this.pmn).setVisibility(8);
        FacingCreateChatRoomAllInOneUI.g(this.pmn).setVisibility(0);
        FacingCreateChatRoomAllInOneUI.m(this.pmn).setVisibility(0);
        FacingCreateChatRoomAllInOneUI.n(this.pmn).setVisibility(0);
        FacingCreateChatRoomAllInOneUI.k(this.pmn).setVisibility(0);
        FacingCreateChatRoomAllInOneUI.o(this.pmn).setVisibility(8);
        FacingCreateChatRoomAllInOneUI.p(this.pmn).setVisibility(8);
        FacingCreateChatRoomAllInOneUI.g(this.pmn).clearAnimation();
        FacingCreateChatRoomAllInOneUI.m(this.pmn).clearAnimation();
        FacingCreateChatRoomAllInOneUI.k(this.pmn).clearAnimation();
    }
}
