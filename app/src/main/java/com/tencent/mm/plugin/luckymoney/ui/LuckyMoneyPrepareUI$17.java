package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.report.service.g;

class LuckyMoneyPrepareUI$17 implements OnClickListener {
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$17(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.ojC = luckyMoneyPrepareUI;
    }

    public final void onClick(View view) {
        g.pQN.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.f(this.ojC)), Integer.valueOf(6)});
        n.a(this.ojC, LuckyMoneyPrepareUI.c(this.ojC), LuckyMoneyPrepareUI.s(this.ojC), true);
        LuckyMoneyPrepareUI.t(this.ojC).postDelayed(new 1(this), 100);
    }
}
