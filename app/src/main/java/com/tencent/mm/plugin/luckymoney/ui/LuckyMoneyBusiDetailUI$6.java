package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.report.service.g;

class LuckyMoneyBusiDetailUI$6 implements OnClickListener {
    final /* synthetic */ LuckyMoneyBusiDetailUI ogR;
    final /* synthetic */ e ogT;

    LuckyMoneyBusiDetailUI$6(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI, e eVar) {
        this.ogR = luckyMoneyBusiDetailUI;
        this.ogT = eVar;
    }

    public final void onClick(View view) {
        g.pQN.h(11701, new Object[]{Integer.valueOf(LuckyMoneyBusiDetailUI.se(this.ogT.ocg)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
        Intent intent = new Intent();
        intent.setClass(this.ogR.mController.xIM, LuckyMoneyMyRecordUI.class);
        intent.putExtra("key_type", 2);
        this.ogR.startActivity(intent);
    }
}
