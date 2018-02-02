package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletSelectBankcardModeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletSelectBankcardModeUI sAn;

    WalletSelectBankcardModeUI$1(WalletSelectBankcardModeUI walletSelectBankcardModeUI) {
        this.sAn = walletSelectBankcardModeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.sAn.setResult(0);
        this.sAn.finish();
        return true;
    }
}
