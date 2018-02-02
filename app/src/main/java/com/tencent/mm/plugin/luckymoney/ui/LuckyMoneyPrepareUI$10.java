package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;

class LuckyMoneyPrepareUI$10 implements Runnable {
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$10(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.ojC = luckyMoneyPrepareUI;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setClass(this.ojC.mController.xIM, LuckyMoneyIndexUI.class);
        intent.addFlags(67108864);
        this.ojC.mController.xIM.startActivity(intent);
        this.ojC.finish();
    }
}
