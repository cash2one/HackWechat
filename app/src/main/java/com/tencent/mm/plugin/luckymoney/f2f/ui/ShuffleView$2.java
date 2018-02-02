package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ShuffleView$2 implements AnimatorListener {
    final /* synthetic */ ShuffleView obk;

    ShuffleView$2(ShuffleView shuffleView) {
        this.obk = shuffleView;
    }

    public final void onAnimationStart(Animator animator) {
        ShuffleView.a(this.obk, true);
    }

    public final void onAnimationEnd(Animator animator) {
        ShuffleView.a(this.obk, false);
        ShuffleView.a(this.obk, null);
        ShuffleView.d(this.obk, -1);
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
