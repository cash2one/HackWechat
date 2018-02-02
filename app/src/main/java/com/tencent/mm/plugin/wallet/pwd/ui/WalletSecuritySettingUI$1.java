package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletSecuritySettingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletSecuritySettingUI sHN;

    WalletSecuritySettingUI$1(WalletSecuritySettingUI walletSecuritySettingUI) {
        this.sHN = walletSecuritySettingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.sHN.finish();
        return false;
    }
}
