package com.tencent.mm.plugin.wallet.loan;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.wallet_core.a;

class WalletLoanCheckPwdUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletLoanCheckPwdUI sDf;

    WalletLoanCheckPwdUI$1(WalletLoanCheckPwdUI walletLoanCheckPwdUI) {
        this.sDf = walletLoanCheckPwdUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        a.m(this.sDf, 0);
        return true;
    }
}
