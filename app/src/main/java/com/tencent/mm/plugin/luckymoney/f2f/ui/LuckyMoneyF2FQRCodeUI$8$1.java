package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.8;

class LuckyMoneyF2FQRCodeUI$8$1 implements AnimatorUpdateListener {
    final /* synthetic */ 8 oaz;

    LuckyMoneyF2FQRCodeUI$8$1(8 8) {
        this.oaz = 8;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        LuckyMoneyF2FQRCodeUI.N(this.oaz.oar).setPadding(LuckyMoneyF2FQRCodeUI.N(this.oaz.oar).getPaddingLeft(), (int) floatValue, LuckyMoneyF2FQRCodeUI.N(this.oaz.oar).getPaddingRight(), LuckyMoneyF2FQRCodeUI.N(this.oaz.oar).getPaddingBottom());
        floatValue /= (float) this.oaz.oax;
        if (floatValue <= 1.0f) {
            LuckyMoneyF2FQRCodeUI.P(this.oaz.oar).setAlpha((1.0f - floatValue) + LuckyMoneyF2FQRCodeUI.O(this.oaz.oar));
            LuckyMoneyF2FQRCodeUI.Q(this.oaz.oar).setAlpha(floatValue * LuckyMoneyF2FQRCodeUI.O(this.oaz.oar));
            return;
        }
        LuckyMoneyF2FQRCodeUI.P(this.oaz.oar).setAlpha(LuckyMoneyF2FQRCodeUI.O(this.oaz.oar));
        LuckyMoneyF2FQRCodeUI.Q(this.oaz.oar).setAlpha(LuckyMoneyF2FQRCodeUI.O(this.oaz.oar));
    }
}
