package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class LuckyMoneyF2FReceiveUI$2 implements AnimatorUpdateListener {
    final /* synthetic */ LuckyMoneyF2FReceiveUI oaJ;

    LuckyMoneyF2FReceiveUI$2(LuckyMoneyF2FReceiveUI luckyMoneyF2FReceiveUI) {
        this.oaJ = luckyMoneyF2FReceiveUI;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        LuckyMoneyF2FReceiveUI.c(this.oaJ).setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) LuckyMoneyF2FReceiveUI.b(this.oaJ).heightPixels));
    }
}
