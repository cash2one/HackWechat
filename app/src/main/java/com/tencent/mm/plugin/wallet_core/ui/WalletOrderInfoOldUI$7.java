package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletOrderInfoOldUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ WalletOrderInfoOldUI sUK;

    WalletOrderInfoOldUI$7(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.sUK = walletOrderInfoOldUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.sUK.done();
        return true;
    }
}
