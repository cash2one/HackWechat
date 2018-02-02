package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletAddAddressUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ WalletAddAddressUI inY;

    WalletAddAddressUI$10(WalletAddAddressUI walletAddAddressUI) {
        this.inY = walletAddAddressUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        WalletAddAddressUI.d(this.inY);
        return true;
    }
}
