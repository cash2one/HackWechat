package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.7;

class SnsCommentFooter$7$1 implements AnimationListener {
    final /* synthetic */ 7 rBq;

    SnsCommentFooter$7$1(7 7) {
        this.rBq = 7;
    }

    public final void onAnimationEnd(Animation animation) {
        SnsCommentFooter.m(this.rBq.rBl).setImageResource(e.qyU);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
