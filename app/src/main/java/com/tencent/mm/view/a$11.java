package com.tencent.mm.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a$11 implements AnimationListener {
    final /* synthetic */ a zDj;

    a$11(a aVar) {
        this.zDj = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.zDj.cAg().setVisibility(0);
        this.zDj.cAh().setVisibility(0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
