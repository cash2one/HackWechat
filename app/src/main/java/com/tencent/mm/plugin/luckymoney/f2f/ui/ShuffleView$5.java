package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

class ShuffleView$5 implements AnimatorListener {
    final /* synthetic */ ShuffleView obk;

    ShuffleView$5(ShuffleView shuffleView) {
        this.obk = shuffleView;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        ShuffleView.e(this.obk).remove(ShuffleView.w(this.obk));
        if (ShuffleView.x(this.obk) != null) {
            ShuffleView.x(this.obk).start();
        }
        ShuffleView.f(this.obk, ShuffleView.f(this.obk));
        if (ShuffleView.d(this.obk) > 0) {
            ShuffleView.e(this.obk, ShuffleView.y(this.obk));
            ShuffleView.b(this.obk, (View) ShuffleView.e(this.obk).get(ShuffleView.f(this.obk)));
            return;
        }
        ShuffleView.b(this.obk, null);
        ShuffleView.e(this.obk, 0);
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
