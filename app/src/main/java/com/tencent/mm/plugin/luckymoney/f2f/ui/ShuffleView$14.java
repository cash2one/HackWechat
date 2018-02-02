package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ShuffleView$14 implements AnimatorUpdateListener {
    final /* synthetic */ ShuffleView obk;

    ShuffleView$14(ShuffleView shuffleView) {
        this.obk = shuffleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = 0;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (floatValue == 0.0f) {
            ShuffleView.b(this.obk).clear();
            ShuffleView.c(this.obk).clear();
            while (i < ShuffleView.d(this.obk)) {
                ShuffleView.b(this.obk).add(Float.valueOf(((View) ShuffleView.e(this.obk).get(i)).getTranslationX()));
                ShuffleView.c(this.obk).add(Float.valueOf(((View) ShuffleView.e(this.obk).get(i)).getTranslationY()));
                i++;
            }
            return;
        }
        for (int i2 = 0; i2 < ShuffleView.d(this.obk); i2++) {
            View view = (View) ShuffleView.e(this.obk).get(i2);
            if (ShuffleView.l(this.obk).obo == 1) {
                view.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.obk).obr) + (1.0f - (ShuffleView.l(this.obk).obr * ((float) (i2 + 1)))));
                view.setTranslationY((((Float) ShuffleView.c(this.obk).get(i2)).floatValue() * (1.0f - floatValue)) + (floatValue * this.obk.rW(i2)));
            } else if (ShuffleView.l(this.obk).obo == 2) {
                view.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(this.obk).obs) + (1.0f - (ShuffleView.l(this.obk).obs * ((float) (i2 + 1)))));
                view.setTranslationX((((Float) ShuffleView.b(this.obk).get(i2)).floatValue() * (1.0f - floatValue)) + (floatValue * this.obk.rV(i2)));
            }
        }
    }
}
