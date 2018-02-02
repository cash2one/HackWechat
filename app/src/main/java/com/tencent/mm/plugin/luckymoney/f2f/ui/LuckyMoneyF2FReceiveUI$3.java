package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mm.sdk.platformtools.x;

class LuckyMoneyF2FReceiveUI$3 implements AnimatorListener {
    final /* synthetic */ LuckyMoneyF2FReceiveUI oaJ;

    LuckyMoneyF2FReceiveUI$3(LuckyMoneyF2FReceiveUI luckyMoneyF2FReceiveUI) {
        this.oaJ = luckyMoneyF2FReceiveUI;
    }

    public final void onAnimationStart(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
        x.i("LuckyMoneyF2FReceiveUI", "packet top in animator end");
        LuckyMoneyF2FReceiveUI.a(this.oaJ).start();
    }

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }
}
