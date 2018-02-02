package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ShuffleView$4 implements AnimatorListener {
    final /* synthetic */ ShuffleView obk;

    ShuffleView$4(ShuffleView shuffleView) {
        this.obk = shuffleView;
    }

    public final void onAnimationStart(Animator animator) {
        ShuffleView.a(this.obk, true);
    }

    public final void onAnimationEnd(Animator animator) {
        ShuffleView.a(this.obk, false);
        ShuffleView.u(this.obk).setVisibility(0);
        if (ShuffleView.v(this.obk) != null) {
            ShuffleView.v(this.obk).start();
        }
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
