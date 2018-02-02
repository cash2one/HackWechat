package com.tencent.mm.plugin.luckymoney.f2f.ui;

class LuckyMoneyF2FQRCodeUI$6 implements ShuffleView$b {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

    LuckyMoneyF2FQRCodeUI$6(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.oar = luckyMoneyF2FQRCodeUI;
    }

    public final void cJ(int i, int i2) {
        if (i2 == 8) {
            LuckyMoneyF2FQRCodeUI.F(this.oar).ew("music" + (i + 1) + ".m4a");
            int[] I = LuckyMoneyF2FQRCodeUI.I(this.oar);
            I[4] = I[4] + 1;
            return;
        }
        LuckyMoneyF2FQRCodeUI.F(this.oar).ew("touch_card.m4a");
        I = LuckyMoneyF2FQRCodeUI.I(this.oar);
        I[2] = I[2] + 1;
    }

    public final void rT(int i) {
        LuckyMoneyF2FQRCodeUI.J(this.oar);
        if (i != 8) {
            LuckyMoneyF2FQRCodeUI.F(this.oar).ew("select_card.m4a");
            int[] I = LuckyMoneyF2FQRCodeUI.I(this.oar);
            I[3] = I[3] + 1;
            return;
        }
        I = LuckyMoneyF2FQRCodeUI.I(this.oar);
        I[5] = I[5] + 1;
    }

    public final void cK(int i, int i2) {
        if (i2 == 8) {
            LuckyMoneyF2FQRCodeUI.F(this.oar).ew("music" + (i + 1) + ".m4a");
        } else {
            LuckyMoneyF2FQRCodeUI.F(this.oar).ew("select_card.m4a");
        }
    }
}
