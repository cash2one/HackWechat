package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletSelectAddrUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ WalletSelectAddrUI iom;

    WalletSelectAddrUI$7(WalletSelectAddrUI walletSelectAddrUI) {
        this.iom = walletSelectAddrUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iom.setResult(0);
        this.iom.finish();
        return true;
    }
}
