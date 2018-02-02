package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class n$10 extends AnimatorListenerAdapter {
    final /* synthetic */ Runnable jDA;
    final /* synthetic */ n jDp;

    n$10(n nVar, Runnable runnable) {
        this.jDp = nVar;
        this.jDA = runnable;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.jDA != null) {
            this.jDA.run();
        }
    }
}
