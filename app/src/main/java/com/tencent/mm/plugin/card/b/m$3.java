package com.tencent.mm.plugin.card.b;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;

class m$3 implements AnimationListener {
    final /* synthetic */ View kXI;
    final /* synthetic */ ScaleAnimation kXJ;

    public m$3(View view, ScaleAnimation scaleAnimation) {
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
