package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class e$7 implements AnimatorListener {
    final /* synthetic */ e rQz;

    e$7(e eVar) {
        this.rQz = eVar;
    }

    public final void onAnimationStart(Animator animator) {
        e.b(this.rQz);
    }

    public final void onAnimationEnd(Animator animator) {
        this.rQz.rQu.setVisibility(4);
        this.rQz.rQu.setTranslationY(0.0f);
    }

    public final void onAnimationCancel(Animator animator) {
        this.rQz.rQu.setVisibility(4);
        this.rQz.rQu.setTranslationY(0.0f);
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
