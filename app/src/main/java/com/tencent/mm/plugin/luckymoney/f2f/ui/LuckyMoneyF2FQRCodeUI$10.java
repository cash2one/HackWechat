package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;

class LuckyMoneyF2FQRCodeUI$10 implements d {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

    LuckyMoneyF2FQRCodeUI$10(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.oar = luckyMoneyF2FQRCodeUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                if (LuckyMoneyF2FQRCodeUI.g(this.oar) > 0) {
                    LuckyMoneyF2FQRCodeUI.h(this.oar);
                    return;
                } else {
                    h.bu(this.oar, this.oar.getString(i.uJS));
                    return;
                }
            default:
                return;
        }
    }
}
