package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletBalanceManagerUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletBalanceManagerUI szV;

    WalletBalanceManagerUI$1(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.szV = walletBalanceManagerUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (WalletBalanceManagerUI.a(this.szV)) {
            this.szV.aWs();
            this.szV.showDialog(1000);
        } else {
            this.szV.finish();
        }
        return true;
    }
}
