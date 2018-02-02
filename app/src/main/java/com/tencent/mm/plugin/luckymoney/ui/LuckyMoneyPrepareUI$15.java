package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class LuckyMoneyPrepareUI$15 implements OnClickListener {
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$15(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.ojC = luckyMoneyPrepareUI;
    }

    public final void onClick(View view) {
        g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.f(this.ojC)), Integer.valueOf(9)});
        Intent intent = new Intent();
        intent.setClass(this.ojC.mController.xIM, LuckyMoneyCanShareListUI.class);
        this.ojC.startActivity(intent);
    }
}
