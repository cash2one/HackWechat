package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletWXCreditChangeAmountUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ WalletWXCreditChangeAmountUI tZW;

    WalletWXCreditChangeAmountUI$5(WalletWXCreditChangeAmountUI walletWXCreditChangeAmountUI) {
        this.tZW = walletWXCreditChangeAmountUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tZW.aWs();
        this.tZW.showDialog(3);
        return true;
    }
}
