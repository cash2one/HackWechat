package com.tencent.mm.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class a$2 implements AnimatorListener {
    final /* synthetic */ a fda;

    a$2(a aVar) {
        this.fda = aVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.fda.fcP.fiC = true;
        this.fda.fdb = false;
        this.fda.fdc = true;
    }

    public final void onAnimationEnd(Animator animator) {
        this.fda.fdb = true;
        this.fda.fdc = false;
        this.fda.fcW = 0;
        this.fda.fcP.uV();
        this.fda.fcP.uT();
        if (this.fda.fcX != null) {
            this.fda.fcX.onAnimationEnd(animator);
        }
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
