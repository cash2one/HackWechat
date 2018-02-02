package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.e;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.report.service.g;

class LuckyMoneyDetailUI$11 implements OnClickListener {
    final /* synthetic */ e ogT;
    final /* synthetic */ LuckyMoneyDetailUI ohM;

    LuckyMoneyDetailUI$11(LuckyMoneyDetailUI luckyMoneyDetailUI, e eVar) {
        this.ohM = luckyMoneyDetailUI;
        this.ogT = eVar;
    }

    public final void onClick(View view) {
        g.pQN.h(11701, new Object[]{Integer.valueOf(LuckyMoneyDetailUI.sf(this.ogT.ocg)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
        n.a(this.ohM, 1, false);
    }
}
