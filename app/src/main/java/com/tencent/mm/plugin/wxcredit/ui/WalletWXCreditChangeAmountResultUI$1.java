package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletWXCreditChangeAmountResultUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountResultUI tZC;

    WalletWXCreditChangeAmountResultUI$1(WalletWXCreditChangeAmountResultUI walletWXCreditChangeAmountResultUI) {
        this.tZC = walletWXCreditChangeAmountResultUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tZC.cCc().a(this.tZC.mController.xIM, 0, this.tZC.vf);
        return true;
    }
}
