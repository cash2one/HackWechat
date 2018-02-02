package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class LuckyMoneyIndexUI$2 implements OnClickListener {
    final /* synthetic */ LuckyMoneyIndexUI ohQ;

    LuckyMoneyIndexUI$2(LuckyMoneyIndexUI luckyMoneyIndexUI) {
        this.ohQ = luckyMoneyIndexUI;
    }

    public final void onClick(View view) {
        g.pQN.h(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
        LuckyMoneyIndexUI.a(this.ohQ, 0);
    }
}
