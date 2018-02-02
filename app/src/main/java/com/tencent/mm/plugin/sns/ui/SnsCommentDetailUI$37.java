package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$37 implements AnimationListener {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$37(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        x.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
        if (SnsCommentDetailUI.B(this.rAr) != null) {
            SnsCommentDetailUI.B(this.rAr).clearAnimation();
            SnsCommentDetailUI.B(this.rAr).setVisibility(8);
        }
    }
}
