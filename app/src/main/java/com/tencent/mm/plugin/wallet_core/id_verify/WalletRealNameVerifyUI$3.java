package com.tencent.mm.plugin.wallet_core.id_verify;

import android.view.View;
import android.view.View.OnClickListener;

class WalletRealNameVerifyUI$3 implements OnClickListener {
    final /* synthetic */ WalletRealNameVerifyUI sJO;

    WalletRealNameVerifyUI$3(WalletRealNameVerifyUI walletRealNameVerifyUI) {
        this.sJO = walletRealNameVerifyUI;
    }

    public final void onClick(View view) {
        WalletRealNameVerifyUI.a(this.sJO, WalletRealNameVerifyUI.b(this.sJO).getText(), WalletRealNameVerifyUI.c(this.sJO).getText());
    }
}
