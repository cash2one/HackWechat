package com.tencent.mm.plugin.luckymoney.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.7;
import com.tencent.mm.plugin.wxpay.a.i;

class LuckyMoneyNewYearReceiveUI$7$1 implements AnimationListener {
    final /* synthetic */ 7 oiR;

    LuckyMoneyNewYearReceiveUI$7$1(7 7) {
        this.oiR = 7;
    }

    public final void onAnimationStart(Animation animation) {
        LuckyMoneyNewYearReceiveUI.j(this.oiR.oiL).setVisibility(0);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        if (g.zY().getInt("PlayCoinSound", 0) > 0) {
            k.H(this.oiR.oiL, i.uJH);
        }
        if (this.oiR.oiQ.ocR != null) {
            this.oiR.oiQ.ocR.b(this.oiR.oiL, null, null);
        }
    }
}
