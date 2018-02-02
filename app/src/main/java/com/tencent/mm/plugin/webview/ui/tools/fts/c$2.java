package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class c$2 implements AnimatorListener {
    final /* synthetic */ c tEK;

    c$2(c cVar) {
        this.tEK = cVar;
    }

    public final void onAnimationStart(Animator animator) {
        this.tEK.isAnimating = true;
        if (this.tEK.tEv != null) {
            this.tEK.tEv.onAnimationStart();
        }
    }

    public final void onAnimationEnd(Animator animator) {
        this.tEK.isAnimating = false;
        if (this.tEK.tEv != null) {
            this.tEK.tEv.onAnimationEnd();
        }
        this.tEK.tEq.setVisibility(0);
        this.tEK.tEr.setAlpha(1.0f);
        this.tEK.tEr.setVisibility(8);
        this.tEK.tEm.setAlpha(1.0f);
        this.tEK.tEm.setVisibility(8);
    }

    public final void onAnimationCancel(Animator animator) {
        this.tEK.isAnimating = false;
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
