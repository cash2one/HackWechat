package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.ui.widget.MMEditText.a;

class LuckyMoneyBusiDetailUI$9 implements a {
    final /* synthetic */ LuckyMoneyBusiDetailUI ogR;

    LuckyMoneyBusiDetailUI$9(LuckyMoneyBusiDetailUI luckyMoneyBusiDetailUI) {
        this.ogR = luckyMoneyBusiDetailUI;
    }

    public final void aXC() {
        if (LuckyMoneyBusiDetailUI.f(this.ogR).getVisibility() == 0) {
            LuckyMoneyBusiDetailUI.f(this.ogR).setVisibility(8);
        } else {
            this.ogR.mController.xIM.finish();
        }
    }
}
