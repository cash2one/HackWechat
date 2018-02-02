package com.tencent.mm.plugin.pwdgroup.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class FacingCreateChatRoomAllInOneUI$9 implements AnimationListener {
    final /* synthetic */ FacingCreateChatRoomAllInOneUI pmn;

    FacingCreateChatRoomAllInOneUI$9(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        this.pmn = facingCreateChatRoomAllInOneUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (FacingCreateChatRoomAllInOneUI.p(this.pmn) != null) {
            FacingCreateChatRoomAllInOneUI.p(this.pmn).hm(true);
        }
    }
}
