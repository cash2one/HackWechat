package com.tencent.mm.plugin.luckymoney.f2f.ui;

import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.HorizontalListViewV2$d;
import com.tencent.mm.ui.base.HorizontalListViewV2.d.a;

class LuckyMoneyF2FQRCodeUI$15 implements HorizontalListViewV2$d {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

    LuckyMoneyF2FQRCodeUI$15(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.oar = luckyMoneyF2FQRCodeUI;
    }

    public final void rU(int i) {
        if (i == a.xYD && LuckyMoneyF2FQRCodeUI.a(this.oar).size() >= 5 && ((long) LuckyMoneyF2FQRCodeUI.a(this.oar).size()) < LuckyMoneyF2FQRCodeUI.v(this.oar) && LuckyMoneyF2FQRCodeUI.w(this.oar).getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.a(this.oar).size() - 1 && !bh.ov(LuckyMoneyF2FQRCodeUI.u(this.oar))) {
            this.oar.l(new v(LuckyMoneyF2FQRCodeUI.u(this.oar), 5, LuckyMoneyF2FQRCodeUI.a(this.oar).size(), null, "v1.0"));
        }
    }
}
