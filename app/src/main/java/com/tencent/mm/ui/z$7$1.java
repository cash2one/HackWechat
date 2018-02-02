package com.tencent.mm.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.ui.z.7;

class z$7$1 implements AnimationListener {
    final /* synthetic */ 7 xLR;

    z$7$1(7 7) {
        this.xLR = 7;
    }

    public final void onAnimationStart(Animation animation) {
        z.a(this.xLR.xLL);
        this.xLR.xLL.w(false, 0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        z.b(this.xLR.xLL);
    }
}
