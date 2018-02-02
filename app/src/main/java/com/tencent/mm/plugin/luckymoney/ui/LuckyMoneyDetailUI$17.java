package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.mm.ui.widget.MMEditText.a;

class LuckyMoneyDetailUI$17 implements a {
    final /* synthetic */ LuckyMoneyDetailUI ohM;

    LuckyMoneyDetailUI$17(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        this.ohM = luckyMoneyDetailUI;
    }

    public final void aXC() {
        if (LuckyMoneyDetailUI.o(this.ohM).getVisibility() == 0) {
            LuckyMoneyDetailUI.o(this.ohM).setVisibility(8);
        } else {
            this.ohM.mController.xIM.finish();
        }
    }
}
