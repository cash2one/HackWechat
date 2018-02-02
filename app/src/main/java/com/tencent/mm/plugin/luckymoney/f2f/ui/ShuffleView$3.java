package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ShuffleView$3 implements AnimatorUpdateListener {
    final /* synthetic */ ShuffleView obk;
    final /* synthetic */ int obl;

    ShuffleView$3(ShuffleView shuffleView, int i) {
        this.obk = shuffleView;
        this.obl = i;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        for (int i = this.obl; i < ShuffleView.d(this.obk) - 1; i++) {
            View view = (View) ShuffleView.e(this.obk).get(i);
            if (ShuffleView.l(this.obk).obo == 1) {
                view.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.obk).obr) + (1.0f - (ShuffleView.l(this.obk).obr * ((float) (i + 1)))));
                if (ShuffleView.l(this.obk).obp == 2) {
                    view.setTranslationY(this.obk.rW(i + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(this.obk)));
                } else if (ShuffleView.l(this.obk).obp == 1) {
                    view.setTranslationY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(this.obk)) + this.obk.rW(i + 1));
                }
            } else if (ShuffleView.l(this.obk).obo == 2) {
                view.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.obk).obs) + (1.0f - (ShuffleView.l(this.obk).obs * ((float) (i + 1)))));
                if (ShuffleView.l(this.obk).obp == 3) {
                    view.setTranslationX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(this.obk)) + this.obk.rV(i + 1));
                } else if (ShuffleView.l(this.obk).obp == 4) {
                    view.setTranslationX(this.obk.rV(i + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(this.obk)));
                }
            }
        }
    }
}
