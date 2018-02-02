package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.plugin.luckymoney.b.ab;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyWishFooter.a;
import com.tencent.mm.sdk.platformtools.bh;

class LuckyMoneyBusiDetailUI$10 implements a {
    final /* synthetic */ LuckyMoneyBusiDetailUI ogR;

    LuckyMoneyBusiDetailUI$10(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI) {
        this.ogR = luckyMoneyBusiDetailUI;
    }

    public final void DY(String str) {
        if (!bh.ov(str) && !bh.ov(LuckyMoneyBusiDetailUI.g(this.ogR))) {
            this.ogR.l(new ab(LuckyMoneyBusiDetailUI.h(this.ogR), str, LuckyMoneyBusiDetailUI.g(this.ogR), "v1.0"));
            LuckyMoneyBusiDetailUI.e(this.ogR);
        }
    }
}
