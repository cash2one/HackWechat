package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class c$1 implements AnimatorListener {
    final /* synthetic */ c tEK;

    c$1(c cVar) {
        this.tEK = cVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.tEK.isAnimating = true;
        if (this.tEK.tEv != null) {
            this.tEK.tEv.onAnimationStart();
        }
        this.tEK.tEo.setVisibility(0);
        this.tEK.tEm.setVisibility(0);
        this.tEK.tEq.setVisibility(8);
        this.tEK.tEr.setVisibility(0);
        this.tEK.tEp.setVisibility(8);
    }

    public final void onAnimationEnd(Animator animator) {
        this.tEK.isAnimating = false;
        if (this.tEK.tEv != null) {
            this.tEK.tEv.onAnimationEnd();
        }
    }

    public final void onAnimationCancel(Animator animator) {
        this.tEK.isAnimating = false;
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
