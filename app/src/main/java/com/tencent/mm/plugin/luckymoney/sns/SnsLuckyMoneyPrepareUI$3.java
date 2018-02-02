package com.tencent.mm.plugin.luckymoney.sns;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;

class SnsLuckyMoneyPrepareUI$3 implements OnClickListener {
    final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

    SnsLuckyMoneyPrepareUI$3(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        this.ofF = snsLuckyMoneyPrepareUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.setClass(this.ofF.mController.xIM, LuckyMoneyMyRecordUI.class);
        intent.putExtra("key_type", 1);
        this.ofF.startActivity(intent);
    }
}
