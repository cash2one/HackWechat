package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.plugin.sns.ui.b.b;

class b$1 implements AnimatorListener {
    final /* synthetic */ b rpT;
    final /* synthetic */ b rpU;

    b$1(b bVar, b bVar2) {
        this.rpU = bVar;
        this.rpT = bVar2;
    }

    public final void onAnimationStart(Animator animator) {
        if (this.rpT != null) {
            this.rpT.onAnimationStart();
        }
        this.rpU.rpS = this.rpU.rpP;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.rpT != null) {
            this.rpT.onAnimationEnd();
        }
        this.rpU.rpS = this.rpU.rpQ;
    }

    public final void onAnimationCancel(Animator animator) {
        this.rpU.rpS = this.rpU.rpQ;
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
