package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.luckymoney.b.ab;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.a;
import com.tencent.mm.sdk.platformtools.bh;

class LuckyMoneyDetailUI$18 implements a {
    final /* synthetic */ LuckyMoneyDetailUI ohM;

    LuckyMoneyDetailUI$18(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        this.ohM = luckyMoneyDetailUI;
    }

    public final void DY(String str) {
        if (!bh.ov(str) && !bh.ov(LuckyMoneyDetailUI.p(this.ohM))) {
            this.ohM.l(new ab(LuckyMoneyDetailUI.q(this.ohM), str, LuckyMoneyDetailUI.p(this.ohM), "v1.0"));
            LuckyMoneyDetailUI.n(this.ohM);
        }
    }
}
