package com.tencent.mm.plugin.appbrand.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mm.plugin.appbrand.ui.b.1;

class b$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ ViewParent jKE;
    final /* synthetic */ 1 jKF;

    b$1$1(1 1, ViewParent viewParent) {
        this.jKF = 1;
        this.jKE = viewParent;
    }

    public final void onAnimationEnd(Animator animator) {
        this.jKF.jKD.setVisibility(8);
        ((ViewGroup) this.jKE).removeView(this.jKF.jKD);
    }
}
