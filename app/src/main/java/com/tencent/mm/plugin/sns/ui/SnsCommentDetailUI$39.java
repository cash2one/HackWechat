package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.plugin.sns.ui.widget.a;

class SnsCommentDetailUI$39 implements AnimationListener {
    final /* synthetic */ float fiX;
    final /* synthetic */ float fiY;
    final /* synthetic */ View rAM;
    final /* synthetic */ View rAN;
    final /* synthetic */ int rAO;
    final /* synthetic */ int rAP;
    final /* synthetic */ SnsCommentDetailUI rAr;
    final /* synthetic */ View ro;

    SnsCommentDetailUI$39(SnsCommentDetailUI snsCommentDetailUI, View view, View view2, int i, View view3, int i2, float f, float f2) {
        this.rAr = snsCommentDetailUI;
        this.rAM = view;
        this.rAN = view2;
        this.rAO = i;
        this.ro = view3;
        this.rAP = i2;
        this.fiX = f;
        this.fiY = f2;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.rAM.setVisibility(0);
        this.rAN.setVisibility(8);
        SnsCommentDetailUI.b(this.rAr, this.rAO);
        Animation aVar = new a(this.ro.getContext(), (float) this.rAP, 0.0f, this.fiX, this.fiY, false);
        aVar.setDuration(187);
        aVar.setInterpolator(new DecelerateInterpolator());
        aVar.setFillAfter(true);
        this.ro.startAnimation(aVar);
    }
}
