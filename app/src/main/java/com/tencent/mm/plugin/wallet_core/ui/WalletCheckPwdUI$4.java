package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletCheckPwdUI$4 implements OnClickListener {
    final /* synthetic */ WalletCheckPwdUI sTs;

    WalletCheckPwdUI$4(WalletCheckPwdUI walletCheckPwdUI) {
        this.sTs = walletCheckPwdUI;
    }

    public final void onClick(View view) {
        WalletCheckPwdUI.bMA();
        if (WalletCheckPwdUI.e(this.sTs) == 0) {
            WalletCheckPwdUI.a(this.sTs, 1);
            WalletCheckPwdUI.f(this.sTs);
        } else {
            WalletCheckPwdUI.a(this.sTs, 0);
        }
        WalletCheckPwdUI.g(this.sTs);
    }
}
