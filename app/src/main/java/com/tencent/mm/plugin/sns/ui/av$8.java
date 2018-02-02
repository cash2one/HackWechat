package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class av$8 implements AnimationListener {
    final /* synthetic */ av rHD;

    av$8(av avVar) {
        this.rHD = avVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.rHD.rHs != null) {
            this.rHD.rHs.clearAnimation();
            this.rHD.rHs.setVisibility(8);
        }
        this.rHD.rHs = null;
    }
}
