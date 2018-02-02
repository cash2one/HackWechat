package com.tencent.mm.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements AnimatorListener {
    final /* synthetic */ c fdi;

    public c$2(c cVar) {
        this.fdi = cVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.fdi.fdb = false;
        this.fdi.fdg = 0.0f;
        this.fdi.fdh = 0.0f;
        x.d("MicroMsg.StickBackAnim", "onAnimationStart");
    }

    public final void onAnimationEnd(Animator animator) {
        this.fdi.fdb = true;
        this.fdi.fdg = 0.0f;
        this.fdi.fdh = 0.0f;
    }

    public final void onAnimationCancel(Animator animator) {
        this.fdi.fdb = true;
        this.fdi.fdg = 0.0f;
        this.fdi.fdh = 0.0f;
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
