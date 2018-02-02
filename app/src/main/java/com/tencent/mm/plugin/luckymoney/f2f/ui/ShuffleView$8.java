package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ShuffleView$8 implements AnimatorUpdateListener {
    final /* synthetic */ ShuffleView obk;
    final /* synthetic */ int obm;
    final /* synthetic */ int obn;

    ShuffleView$8(ShuffleView shuffleView, int i, int i2) {
        this.obk = shuffleView;
        this.obm = i;
        this.obn = i2;
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
        int i2;
        if (this.obm > 0) {
            for (i2 = 0; i2 < ShuffleView.f(this.obk) - 1; i2++) {
                ((View) ShuffleView.e(this.obk).get(i2)).setTranslationX((((Float) ShuffleView.b(this.obk).get(i2)).floatValue() * (1.0f - floatValue)) + ((this.obk.rV(i2) - (((float) (i2 + 1)) * ShuffleView.g(this.obk))) * floatValue));
                ((View) ShuffleView.e(this.obk).get(i2)).setTranslationY((((Float) ShuffleView.c(this.obk).get(i2)).floatValue() * (1.0f - floatValue)) + (this.obk.rW(i2) * floatValue));
            }
            ((View) ShuffleView.e(this.obk).get(ShuffleView.f(this.obk) - 1)).setTranslationX((((Float) ShuffleView.b(this.obk).get(ShuffleView.f(this.obk) - 1)).floatValue() * (1.0f - floatValue)) + ((this.obk.rV(ShuffleView.f(this.obk) - 1) - ((ShuffleView.g(this.obk) * ((float) this.obm)) / 2.0f)) * floatValue));
            ((View) ShuffleView.e(this.obk).get(ShuffleView.f(this.obk) - 1)).setTranslationY((((Float) ShuffleView.c(this.obk).get(ShuffleView.f(this.obk) - 1)).floatValue() * (1.0f - floatValue)) + (this.obk.rW(ShuffleView.f(this.obk) - 1) * floatValue));
        } else {
            for (i2 = 0; i2 < ShuffleView.f(this.obk); i2++) {
                ((View) ShuffleView.e(this.obk).get(i2)).setTranslationX((((Float) ShuffleView.b(this.obk).get(i2)).floatValue() * (1.0f - floatValue)) + (this.obk.rV(i2) * floatValue));
                ((View) ShuffleView.e(this.obk).get(i2)).setTranslationY((((Float) ShuffleView.c(this.obk).get(i2)).floatValue() * (1.0f - floatValue)) + (this.obk.rW(i2) * floatValue));
            }
        }
        if (this.obn > 0) {
            ShuffleView.h(this.obk).setTranslationX((((Float) ShuffleView.b(this.obk).get(ShuffleView.f(this.obk))).floatValue() * (1.0f - floatValue)) + ((this.obk.rV(ShuffleView.f(this.obk)) + ((ShuffleView.g(this.obk) * ((float) this.obn)) / 2.0f)) * floatValue));
            for (i2 = ShuffleView.f(this.obk) + 1; i2 < ShuffleView.d(this.obk); i2++) {
                ((View) ShuffleView.e(this.obk).get(i2)).setTranslationX((((Float) ShuffleView.b(this.obk).get(i2)).floatValue() * (1.0f - floatValue)) + ((this.obk.rV(i2) + (((float) (ShuffleView.d(this.obk) - i2)) * ShuffleView.g(this.obk))) * floatValue));
                ((View) ShuffleView.e(this.obk).get(i2)).setTranslationY((((Float) ShuffleView.c(this.obk).get(i2)).floatValue() * (1.0f - floatValue)) + (this.obk.rW(i2) * floatValue));
            }
        } else {
            for (i2 = ShuffleView.f(this.obk); i2 < ShuffleView.d(this.obk); i2++) {
                ((View) ShuffleView.e(this.obk).get(i2)).setTranslationX((((Float) ShuffleView.b(this.obk).get(i2)).floatValue() * (1.0f - floatValue)) + (this.obk.rV(i2) * floatValue));
                ((View) ShuffleView.e(this.obk).get(i2)).setTranslationY((((Float) ShuffleView.c(this.obk).get(i2)).floatValue() * (1.0f - floatValue)) + (this.obk.rW(i2) * floatValue));
            }
        }
        ShuffleView.h(this.obk).setTranslationY((((Float) ShuffleView.c(this.obk).get(ShuffleView.f(this.obk))).floatValue() * (1.0f - floatValue)) - ((((float) ShuffleView.h(this.obk).getHeight()) * floatValue) / 7.0f));
    }
}
