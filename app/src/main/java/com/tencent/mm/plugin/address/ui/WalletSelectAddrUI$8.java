package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletSelectAddrUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ WalletSelectAddrUI iom;

    WalletSelectAddrUI$8(WalletSelectAddrUI walletSelectAddrUI) {
        this.iom = walletSelectAddrUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        WalletSelectAddrUI.i(this.iom);
        return true;
    }
}
