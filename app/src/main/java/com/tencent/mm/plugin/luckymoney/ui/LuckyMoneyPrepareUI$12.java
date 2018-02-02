package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class LuckyMoneyPrepareUI$12 implements OnClickListener {
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$12(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.ojC = luckyMoneyPrepareUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.setClass(this.ojC.mController.xIM, LuckyMoneyMyRecordUI.class);
        intent.putExtra("key_type", 1);
        this.ojC.startActivity(intent);
    }
}
