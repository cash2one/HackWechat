package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletWXCreditOpenNotifyUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletWXCreditOpenNotifyUI uaj;

    WalletWXCreditOpenNotifyUI$1(WalletWXCreditOpenNotifyUI walletWXCreditOpenNotifyUI) {
        this.uaj = walletWXCreditOpenNotifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.uaj.setResult(-1);
        this.uaj.finish();
        return true;
    }
}
