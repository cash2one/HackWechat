package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class LuckyMoneyReceiveUI$5 implements OnClickListener {
    final /* synthetic */ LuckyMoneyReceiveUI ojZ;

    LuckyMoneyReceiveUI$5(LuckyMoneyReceiveUI luckyMoneyReceiveUI) {
        this.ojZ = luckyMoneyReceiveUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.ojZ.mController.xIM, LuckyMoneyDetailUI.class);
        intent.putExtra("key_native_url", LuckyMoneyReceiveUI.d(this.ojZ).fLC);
        intent.putExtra("key_sendid", LuckyMoneyReceiveUI.d(this.ojZ).nZa);
        this.ojZ.startActivity(intent);
        this.ojZ.finish();
    }
}
