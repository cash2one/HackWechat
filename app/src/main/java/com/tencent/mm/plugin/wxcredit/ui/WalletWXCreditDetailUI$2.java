package com.tencent.mm.plugin.wxcredit.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WalletWXCreditDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ WalletWXCreditDetailUI uad;

    WalletWXCreditDetailUI$2(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        this.uad = walletWXCreditDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.uad.aWs();
        this.uad.finish();
        return true;
    }
}
