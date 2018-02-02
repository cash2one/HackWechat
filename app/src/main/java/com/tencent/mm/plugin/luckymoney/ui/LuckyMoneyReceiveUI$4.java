package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class LuckyMoneyReceiveUI$4 implements OnClickListener {
    final /* synthetic */ LuckyMoneyReceiveUI ojZ;
    final /* synthetic */ boolean oka;

    LuckyMoneyReceiveUI$4(LuckyMoneyReceiveUI luckyMoneyReceiveUI, boolean z) {
        this.ojZ = luckyMoneyReceiveUI;
        this.oka = z;
    }

    public final void onClick(View view) {
        if (this.oka) {
            g.pQN.h(11701, Integer.valueOf(6), Integer.valueOf(LuckyMoneyReceiveUI.sk(LuckyMoneyReceiveUI.d(this.ojZ).obK)), Integer.valueOf(LuckyMoneyReceiveUI.e(this.ojZ)), Integer.valueOf(0), Integer.valueOf(1));
        }
        Intent intent = new Intent();
        intent.setClass(this.ojZ.mController.xIM, LuckyMoneyDetailUI.class);
        intent.putExtra("key_native_url", LuckyMoneyReceiveUI.d(this.ojZ).fLC);
        intent.putExtra("key_sendid", LuckyMoneyReceiveUI.d(this.ojZ).nZa);
        this.ojZ.startActivity(intent);
        this.ojZ.finish();
    }
}
