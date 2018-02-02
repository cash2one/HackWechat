package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.2;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.protocal.c.rf;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.wallet_core.ui.e;

class WalletLqtDetailUI$2$2 implements p$d {
    final /* synthetic */ 2 sAN;

    WalletLqtDetailUI$2$2(2 2) {
        this.sAN = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (menuItem.getItemId() == -1 && !WalletLqtDetailUI.c(this.sAN.sAM).wGQ) {
            h.a(this.sAN.sAM, this.sAN.sAM.getString(a$i.uSs), "", this.sAN.sAM.getString(a$i.bWk), new 1(this));
        } else if (WalletLqtDetailUI.c(this.sAN.sAM).wGJ != null && WalletLqtDetailUI.c(this.sAN.sAM).wGJ.size() > 0 && menuItem.getItemId() < WalletLqtDetailUI.c(this.sAN.sAM).wGJ.size()) {
            e.l(this.sAN.sAM, ((rf) WalletLqtDetailUI.c(this.sAN.sAM).wGJ.get(menuItem.getItemId())).vZl, false);
        }
    }
}
