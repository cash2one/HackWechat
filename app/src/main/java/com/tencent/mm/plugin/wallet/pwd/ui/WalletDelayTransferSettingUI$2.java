package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletDelayTransferSettingUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ WalletDelayTransferSettingUI sGH;

    WalletDelayTransferSettingUI$2(WalletDelayTransferSettingUI walletDelayTransferSettingUI) {
        this.sGH = walletDelayTransferSettingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.sGH.finish();
        return false;
    }
}
