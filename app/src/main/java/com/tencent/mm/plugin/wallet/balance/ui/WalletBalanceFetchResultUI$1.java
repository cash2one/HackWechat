package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletBalanceFetchResultUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletBalanceFetchResultUI szj;

    WalletBalanceFetchResultUI$1(WalletBalanceFetchResultUI walletBalanceFetchResultUI) {
        this.szj = walletBalanceFetchResultUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        WalletBalanceFetchResultUI.a(this.szj);
        return false;
    }
}
