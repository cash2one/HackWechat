package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.b;

class SnsCommentFooter$7 implements OnClickListener {
    final /* synthetic */ SnsCommentFooter rBl;
    final /* synthetic */ b rBp;

    SnsCommentFooter$7(SnsCommentFooter snsCommentFooter, b bVar) {
        this.rBl = snsCommentFooter;
        this.rBp = bVar;
    }

    public final void onClick(View view) {
        SnsCommentFooter.m(this.rBl).setImageResource(e.qyV);
        Animation scaleAnimation = new ScaleAnimation(0.9f, 1.3f, 0.9f, 1.3f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400);
        scaleAnimation.setStartOffset(100);
        scaleAnimation.setRepeatCount(0);
        SnsCommentFooter.m(this.rBl).startAnimation(scaleAnimation);
        scaleAnimation.setAnimationListener(new 1(this));
        this.rBp.bAI();
    }
}
