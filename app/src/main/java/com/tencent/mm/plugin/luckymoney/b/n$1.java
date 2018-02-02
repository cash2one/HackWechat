package com.tencent.mm.plugin.luckymoney.b;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;

class n$1 implements AnimationListener {
    final /* synthetic */ View kXI;
    final /* synthetic */ ScaleAnimation kXJ;

    n$1(View view, ScaleAnimation scaleAnimation) {
        this.kXI = view;
        this.kXJ = scaleAnimation;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.kXI.startAnimation(this.kXJ);
    }
}
