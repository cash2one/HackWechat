package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bh$2 implements AnimationListener {
    final /* synthetic */ View qZI;
    final /* synthetic */ bh rMM;

    bh$2(bh bhVar, View view) {
        this.rMM = bhVar;
        this.qZI = view;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.qZI != null) {
            this.qZI.setVisibility(8);
            this.rMM.bzr();
        }
    }
}
