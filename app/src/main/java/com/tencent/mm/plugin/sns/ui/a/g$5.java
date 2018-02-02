package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.plugin.sns.ui.a.g.a;

class g$5 implements AnimationListener {
    final /* synthetic */ float fiX;
    final /* synthetic */ float fiY;
    final /* synthetic */ View rAM;
    final /* synthetic */ View rAN;
    final /* synthetic */ int rAP;
    final /* synthetic */ g rPe;
    final /* synthetic */ a rPf;
    final /* synthetic */ View ro;

    public g$5(g gVar, View view, View view2, a aVar, View view3, int i, float f, float f2) {
        this.rPe = gVar;
        this.rAM = view;
        this.rAN = view2;
        this.rPf = aVar;
        this.ro = view3;
        this.rAP = i;
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
        g.b(this.rPf.rPi);
        Animation aVar = new com.tencent.mm.plugin.sns.ui.widget.a(this.ro.getContext(), (float) this.rAP, 0.0f, this.fiX, this.fiY, false);
        aVar.setDuration(187);
        aVar.setInterpolator(new DecelerateInterpolator());
        aVar.setFillAfter(true);
        this.ro.startAnimation(aVar);
    }
}
