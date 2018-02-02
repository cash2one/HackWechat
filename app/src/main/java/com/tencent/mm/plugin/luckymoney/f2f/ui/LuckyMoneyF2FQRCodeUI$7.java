package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class LuckyMoneyF2FQRCodeUI$7 implements AnimatorUpdateListener {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

    LuckyMoneyF2FQRCodeUI$7(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.oar = luckyMoneyF2FQRCodeUI;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        LuckyMoneyF2FQRCodeUI.E(this.oar).setTranslationY((-0.5f * floatValue) * ((float) LuckyMoneyF2FQRCodeUI.K(this.oar).heightPixels));
        LuckyMoneyF2FQRCodeUI.D(this.oar).setAlpha(1.0f - floatValue);
        if (floatValue == 1.0f) {
            LuckyMoneyF2FQRCodeUI.E(this.oar).setVisibility(8);
            LuckyMoneyF2FQRCodeUI.E(this.oar).setTranslationY(0.0f);
            LuckyMoneyF2FQRCodeUI.L(this.oar);
            LuckyMoneyF2FQRCodeUI.M(this.oar).notifyDataSetChanged();
            LuckyMoneyF2FQRCodeUI.w(this.oar).Es(0);
        }
    }
}
