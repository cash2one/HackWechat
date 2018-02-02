package com.tencent.mm.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a$9 implements AnimationListener {
    final /* synthetic */ a zDj;

    a$9(a aVar) {
        this.zDj = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.zDj.cAh().setVisibility(0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
