package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletChangeLoanRepayBankcardUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletChangeLoanRepayBankcardUI sEX;

    WalletChangeLoanRepayBankcardUI$1(WalletChangeLoanRepayBankcardUI walletChangeLoanRepayBankcardUI) {
        this.sEX = walletChangeLoanRepayBankcardUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.sEX.setResult(-1, null);
        return true;
    }
}
