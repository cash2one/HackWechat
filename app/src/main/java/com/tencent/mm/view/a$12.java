package com.tencent.mm.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a$12 implements AnimationListener {
    final /* synthetic */ a zDj;

    a$12(a aVar) {
        this.zDj = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.zDj.cAg().setVisibility(8);
        this.zDj.cAh().setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
