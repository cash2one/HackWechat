package com.tencent.mm.plugin.game.gamewebview.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class c$7 extends AnimatorListenerAdapter {
    final /* synthetic */ Runnable jDA;
    final /* synthetic */ c mYA;

    c$7(c cVar, Runnable runnable) {
        this.mYA = cVar;
        this.jDA = runnable;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.jDA != null) {
            this.jDA.run();
        }
    }
}
