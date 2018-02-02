package com.tencent.mm.plugin.luckymoney.sns;

import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import com.tencent.mm.plugin.wxpay.a.f;

class SnsLuckyMoneyPrepareUI$7 implements Runnable {
    final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

    SnsLuckyMoneyPrepareUI$7(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        this.ofF = snsLuckyMoneyPrepareUI;
    }

    public final void run() {
        SnsLuckyMoneyPrepareUI.l(this.ofF).setVisibility(0);
        Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(800);
        scaleAnimation.setStartOffset(200);
        scaleAnimation.setInterpolator(new BounceInterpolator());
        this.ofF.findViewById(f.upf).startAnimation(scaleAnimation);
    }
}
