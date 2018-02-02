package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletLockCheckPwdUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WalletLockCheckPwdUI sHg;

    WalletLockCheckPwdUI$1(WalletLockCheckPwdUI walletLockCheckPwdUI) {
        this.sHg = walletLockCheckPwdUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
        WalletLockCheckPwdUI.a(this.sHg);
        return true;
    }
}
