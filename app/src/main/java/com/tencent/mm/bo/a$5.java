package com.tencent.mm.bo;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a$5 implements AnimationListener {
    final /* synthetic */ a vAf;

    a$5(a aVar) {
        this.vAf = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.vAf.vzW.cAj().setVisibility(0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
