package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletVerifyCodeUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ WalletVerifyCodeUI sWR;

    WalletVerifyCodeUI$12(WalletVerifyCodeUI walletVerifyCodeUI) {
        this.sWR = walletVerifyCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.sWR.aWs();
        if (this.sWR.bKa()) {
            this.sWR.showDialog(1000);
        } else {
            this.sWR.finish();
        }
        return false;
    }
}
