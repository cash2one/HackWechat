package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletVerifyCodeUI$6 implements OnClickListener {
    final /* synthetic */ WalletVerifyCodeUI sWR;

    WalletVerifyCodeUI$6(WalletVerifyCodeUI walletVerifyCodeUI) {
        this.sWR = walletVerifyCodeUI;
    }

    public final void onClick(View view) {
        if (!WalletVerifyCodeUI.a(this.sWR, WalletVerifyCodeUI.a(this.sWR))) {
            this.sWR.bMV();
        }
    }
}
