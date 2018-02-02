package com.tencent.mm.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletBaseUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ WalletBaseUI zJd;

    WalletBaseUI$3(WalletBaseUI walletBaseUI) {
        this.zJd = walletBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (this.zJd.bKa()) {
            this.zJd.aWs();
            this.zJd.showDialog(1000);
        } else {
            this.zJd.finish();
        }
        return true;
    }
}
