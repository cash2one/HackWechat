package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class f$1 extends AnimatorListenerAdapter {
    final /* synthetic */ f tyh;

    f$1(f fVar) {
        this.tyh = fVar;
    }

    public final void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
        f.a(this.tyh);
    }

    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        f.a(this.tyh);
    }
}
