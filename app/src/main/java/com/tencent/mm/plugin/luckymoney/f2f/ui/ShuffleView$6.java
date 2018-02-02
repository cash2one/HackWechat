package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ShuffleView$6 implements AnimatorUpdateListener {
    final /* synthetic */ ShuffleView obk;

    ShuffleView$6(ShuffleView shuffleView) {
        this.obk = shuffleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (ShuffleView.z(this.obk) != null) {
            ShuffleView.z(this.obk).a(valueAnimator, ShuffleView.w(this.obk));
        }
    }
}
