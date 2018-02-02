package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class WalletForgotPwdUI$1 implements OnClickListener {
    final /* synthetic */ WalletForgotPwdUI sGW;

    WalletForgotPwdUI$1(WalletForgotPwdUI walletForgotPwdUI) {
        this.sGW = walletForgotPwdUI;
    }

    public final void onClick(View view) {
        g.pQN.h(11353, Integer.valueOf(1), Integer.valueOf(0));
        WalletForgotPwdUI.a(this.sGW);
    }
}
