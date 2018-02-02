package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class c$3 implements AnimationListener {
    final /* synthetic */ View qZI;
    final /* synthetic */ c rqg;

    c$3(c cVar, View view) {
        this.rqg = cVar;
        this.qZI = view;
    }

    public final void onAnimationStart(Animation animation) {
        this.rqg.qZt = true;
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.qZI != null) {
            this.qZI.clearAnimation();
            this.qZI.setVisibility(8);
            this.rqg.bwm();
        }
        this.rqg.qZt = false;
    }
}
