package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class c$5 extends AnimatorListenerAdapter {
    final /* synthetic */ Runnable jDA;
    final /* synthetic */ c jUG;

    c$5(c cVar, Runnable runnable) {
        this.jUG = cVar;
        this.jDA = runnable;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.jDA != null) {
            this.jUG.post(this.jDA);
        }
    }
}
