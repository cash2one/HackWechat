package com.tencent.mm.ui.base;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.ui.base.i.1;

class i$1$2 implements AnimationListener {
    final /* synthetic */ 1 xZo;

    i$1$2(1 1) {
        this.xZo = 1;
    }

    public final void onAnimationStart(Animation animation) {
        i.a(this.xZo.xZn, i.f(this.xZo.xZn));
    }

    public final void onAnimationEnd(Animation animation) {
        i.c(this.xZo.xZn).setVisibility(0);
        i.a(this.xZo.xZn, 8);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
