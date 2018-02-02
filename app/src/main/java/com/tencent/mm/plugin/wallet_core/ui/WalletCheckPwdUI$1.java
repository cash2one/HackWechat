package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletCheckPwdUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletCheckPwdUI sTs;

    WalletCheckPwdUI$1(WalletCheckPwdUI walletCheckPwdUI) {
        this.sTs = walletCheckPwdUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        WalletCheckPwdUI.a(this.sTs);
        return false;
    }
}
