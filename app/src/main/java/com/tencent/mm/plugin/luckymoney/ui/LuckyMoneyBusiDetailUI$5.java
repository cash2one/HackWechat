package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.report.service.g;

class LuckyMoneyBusiDetailUI$5 implements OnClickListener {
    final /* synthetic */ LuckyMoneyBusiDetailUI ogR;
    final /* synthetic */ e ogT;

    LuckyMoneyBusiDetailUI$5(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI, e eVar) {
        this.ogR = luckyMoneyBusiDetailUI;
        this.ogT = eVar;
    }

    public final void onClick(View view) {
        g.pQN.h(11701, new Object[]{Integer.valueOf(LuckyMoneyBusiDetailUI.se(this.ogT.ocg)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
        n.a(this.ogR, 1, false);
    }
}
