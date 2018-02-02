package com.tencent.mm.ui.tools;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.ui.tools.g.b;

class g$1 implements AnimatorListener {
    final /* synthetic */ b zkQ;
    final /* synthetic */ g zkR;

    g$1(g gVar, b bVar) {
        this.zkR = gVar;
        this.zkQ = bVar;
    }

    public final void onAnimationStart(Animator animator) {
        if (this.zkQ != null) {
            this.zkQ.onAnimationStart();
        }
        this.zkR.rpS = this.zkR.rpP;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.zkQ != null) {
            this.zkQ.onAnimationEnd();
        }
        this.zkR.rpS = this.zkR.rpQ;
    }

    public final void onAnimationCancel(Animator animator) {
        this.zkR.rpS = this.zkR.rpQ;
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
