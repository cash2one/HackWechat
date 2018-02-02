package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.util.Pair;
import android.view.View;
import com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyF2FQRCodeUI$5 implements a {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

    LuckyMoneyF2FQRCodeUI$5(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.oar = luckyMoneyF2FQRCodeUI;
    }

    public final void a(ValueAnimator valueAnimator, View view) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (floatValue == 0.0f) {
            LuckyMoneyF2FQRCodeUI.a(this.oar, view.getTranslationX());
            LuckyMoneyF2FQRCodeUI.b(this.oar, view.getTranslationY());
            view.findViewById(f.unQ).setVisibility(0);
        }
        view.setTranslationX((1.0f - floatValue) * LuckyMoneyF2FQRCodeUI.A(this.oar));
        view.setTranslationY(((1.0f - floatValue) * LuckyMoneyF2FQRCodeUI.B(this.oar)) - ((((float) LuckyMoneyF2FQRCodeUI.c(this.oar).getHeight()) + (LuckyMoneyF2FQRCodeUI.B(this.oar) * 8.0f)) * floatValue));
        view.setScaleX((0.5f * floatValue) + 1.0f);
        view.setScaleY((0.5f * floatValue) + 1.0f);
        Pair pair = (Pair) LuckyMoneyF2FQRCodeUI.f(this.oar).peek();
        if (!(pair == null || bh.ov(LuckyMoneyF2FQRCodeUI.C(this.oar)) || !LuckyMoneyF2FQRCodeUI.C(this.oar).equals(pair.first))) {
            LuckyMoneyF2FQRCodeUI.D(this.oar).setAlpha(floatValue);
        }
        x.i("LuckyMoneyF2FQRCodeUI", "fireworkBottomLayer %f", new Object[]{Float.valueOf(floatValue)});
        if (floatValue >= 0.9f) {
            view.setAlpha((1.0f - floatValue) * 10.0f);
            LuckyMoneyF2FQRCodeUI.E(this.oar).setAlpha(1.0f - ((1.0f - floatValue) * 10.0f));
            LuckyMoneyF2FQRCodeUI.E(this.oar).setScaleX(floatValue);
            LuckyMoneyF2FQRCodeUI.E(this.oar).setScaleY(floatValue);
            LuckyMoneyF2FQRCodeUI.E(this.oar).setVisibility(0);
        }
        if (floatValue == 1.0f) {
            LuckyMoneyF2FQRCodeUI.F(this.oar).ew("packet_received.m4a");
            LuckyMoneyF2FQRCodeUI.c(this.oar).removeView(LuckyMoneyF2FQRCodeUI.c(this.oar).oaS);
            LuckyMoneyF2FQRCodeUI.G(this.oar);
            LuckyMoneyF2FQRCodeUI.H(this.oar).start();
        }
    }
}
