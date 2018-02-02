package com.tencent.mm.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a$10 implements AnimationListener {
    final /* synthetic */ a zDj;

    a$10(a aVar) {
        this.zDj = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.zDj.cAh().setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
