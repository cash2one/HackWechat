package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import com.tencent.mm.plugin.wallet_core.ui.g.a;

class WalletForgotPwdUI$5 implements a {
    final /* synthetic */ WalletForgotPwdUI sGW;

    WalletForgotPwdUI$5(WalletForgotPwdUI walletForgotPwdUI) {
        this.sGW = walletForgotPwdUI;
    }

    public final void onClick(View view) {
        WalletForgotPwdUI.a(this.sGW, true);
        WalletForgotPwdUI.a(this.sGW);
    }
}
