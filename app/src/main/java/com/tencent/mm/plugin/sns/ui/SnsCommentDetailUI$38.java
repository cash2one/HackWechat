package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

class SnsCommentDetailUI$38 implements AnimationListener {
    boolean rAK = false;
    final /* synthetic */ LinearLayout rAL;
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$38(SnsCommentDetailUI snsCommentDetailUI, LinearLayout linearLayout) {
        this.rAr = snsCommentDetailUI;
        this.rAL = linearLayout;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.rAL != null) {
            this.rAL.setPressed(false);
        }
        if (!this.rAK) {
            this.rAK = true;
            if (SnsCommentDetailUI.B(this.rAr) != null) {
                SnsCommentDetailUI.B(this.rAr).clearAnimation();
                SnsCommentDetailUI.B(this.rAr).setVisibility(8);
            }
        }
        SnsCommentDetailUI.D(this.rAr);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
