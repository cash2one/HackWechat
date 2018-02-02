package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class b$5 implements AnimatorListener {
    final /* synthetic */ b tEI;

    b$5(b bVar) {
        this.tEI = bVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.tEI.isAnimating = true;
        if (this.tEI.tEv != null) {
            this.tEI.tEv.onAnimationStart();
        }
        this.tEI.tEn.setVisibility(8);
        this.tEI.tEp.setVisibility(0);
    }

    public final void onAnimationEnd(Animator animator) {
        this.tEI.isAnimating = false;
        if (this.tEI.tEv != null) {
            this.tEI.tEv.onAnimationEnd();
        }
        this.tEI.tEq.setVisibility(0);
        this.tEI.tEo.setAlpha(1.0f);
        this.tEI.tEo.setVisibility(8);
    }

    public final void onAnimationCancel(Animator animator) {
        this.tEI.isAnimating = false;
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
