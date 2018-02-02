package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class LuckyMoneyBusiReceiveUI$4 implements OnClickListener {
    final /* synthetic */ LuckyMoneyBusiReceiveUI ohm;

    LuckyMoneyBusiReceiveUI$4(LuckyMoneyBusiReceiveUI luckyMoneyBusiReceiveUI) {
        this.ohm = luckyMoneyBusiReceiveUI;
    }

    public final void onClick(View view) {
        g.pQN.h(11701, new Object[]{Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
        if (LuckyMoneyBusiReceiveUI.f(this.ohm).isChecked()) {
            g.pQN.h(13050, new Object[]{Integer.valueOf(LuckyMoneyBusiReceiveUI.g(this.ohm)), Integer.valueOf(2), LuckyMoneyBusiReceiveUI.h(this.ohm).ocO});
        } else {
            g.pQN.h(13050, new Object[]{Integer.valueOf(LuckyMoneyBusiReceiveUI.g(this.ohm)), Integer.valueOf(2), ""});
        }
        LuckyMoneyBusiReceiveUI.i(this.ohm);
    }
}
