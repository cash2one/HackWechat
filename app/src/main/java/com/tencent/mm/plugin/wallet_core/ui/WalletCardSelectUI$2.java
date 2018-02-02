package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletCardSelectUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ WalletCardSelectUI sSV;

    WalletCardSelectUI$2(WalletCardSelectUI walletCardSelectUI) {
        this.sSV = walletCardSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.sSV.finish();
        return true;
    }
}
