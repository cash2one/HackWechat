package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class LuckyMoneyNewYearReceiveUI$2 implements OnClickListener {
    final /* synthetic */ LuckyMoneyNewYearReceiveUI oiL;

    LuckyMoneyNewYearReceiveUI$2(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        this.oiL = luckyMoneyNewYearReceiveUI;
    }

    public final void onClick(View view) {
        this.oiL.finish();
        g.pQN.h(13079, new Object[]{Integer.valueOf(6), Integer.valueOf(2)});
    }
}
