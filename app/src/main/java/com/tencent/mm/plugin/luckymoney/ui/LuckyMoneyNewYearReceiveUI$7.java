package com.tencent.mm.plugin.luckymoney.ui;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.plugin.luckymoney.b.n;

class LuckyMoneyNewYearReceiveUI$7 implements LuckyMoneyAutoScrollView$a {
    final /* synthetic */ LuckyMoneyNewYearReceiveUI oiL;
    final /* synthetic */ ac oiQ;

    LuckyMoneyNewYearReceiveUI$7(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI, ac acVar) {
        this.oiL = luckyMoneyNewYearReceiveUI;
        this.oiQ = acVar;
    }

    public final void aXx() {
        LuckyMoneyNewYearReceiveUI.j(this.oiL).setVisibility(4);
        n.a(this.oiL.mController.xIM, LuckyMoneyNewYearReceiveUI.j(this.oiL), this.oiQ.ocQ.obN);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setAnimationListener(new 1(this));
        LuckyMoneyNewYearReceiveUI.j(this.oiL).startAnimation(alphaAnimation);
    }
}
