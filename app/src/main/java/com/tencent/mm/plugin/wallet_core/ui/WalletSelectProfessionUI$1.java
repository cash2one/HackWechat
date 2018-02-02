package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletSelectProfessionUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletSelectProfessionUI sWq;

    WalletSelectProfessionUI$1(WalletSelectProfessionUI walletSelectProfessionUI) {
        this.sWq = walletSelectProfessionUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.sWq.setResult(0);
        this.sWq.finish();
        return true;
    }
}
