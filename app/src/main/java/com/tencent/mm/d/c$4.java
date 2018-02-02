package com.tencent.mm.d;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class c$4 implements AnimatorListener {
    final /* synthetic */ c fiO;

    c$4(c cVar) {
        this.fiO = cVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.fiO.fiC = true;
        c.a(this.fiO, true);
    }

    public final void onAnimationEnd(Animator animator) {
        c.a(this.fiO, true);
    }

    public final void onAnimationCancel(Animator animator) {
        c.a(this.fiO, false);
        animator.removeAllListeners();
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
