package com.tencent.mm.plugin.luckymoney.ui;

import android.os.CountDownTimer;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyAutoScrollItem.1;

class LuckyMoneyAutoScrollItem$1$1 extends CountDownTimer {
    final /* synthetic */ 1 ofX;

    LuckyMoneyAutoScrollItem$1$1(1 1, long j) {
        this.ofX = 1;
        super(j, 50);
    }

    public final void onTick(long j) {
        this.ofX.ofW.smoothScrollToPosition(LuckyMoneyAutoScrollItem.a(this.ofX.ofW));
    }

    public final void onFinish() {
        if (this.ofX.ofW.ofT != null) {
            this.ofX.ofW.ofT.aXw();
        }
    }
}
