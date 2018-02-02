package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletLqtSimpleCheckPwdUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletLqtSimpleCheckPwdUI sBI;

    WalletLqtSimpleCheckPwdUI$1(WalletLqtSimpleCheckPwdUI walletLqtSimpleCheckPwdUI) {
        this.sBI = walletLqtSimpleCheckPwdUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.sBI.finish();
        return false;
    }
}
