package com.tencent.mm.bo;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class a$6 implements AnimationListener {
    final /* synthetic */ a vAf;

    a$6(a aVar) {
        this.vAf = aVar;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.vAf.vzW.cAj().setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
