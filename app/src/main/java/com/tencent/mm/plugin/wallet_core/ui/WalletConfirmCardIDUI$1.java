package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.wallet_core.c.o;

class WalletConfirmCardIDUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletConfirmCardIDUI sTz;

    WalletConfirmCardIDUI$1(WalletConfirmCardIDUI walletConfirmCardIDUI) {
        this.sTz = walletConfirmCardIDUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        o.cBv();
        this.sTz.finish();
        return false;
    }
}
