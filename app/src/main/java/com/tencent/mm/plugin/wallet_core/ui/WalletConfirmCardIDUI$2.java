package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletConfirmCardIDUI$2 implements OnClickListener {
    final /* synthetic */ WalletConfirmCardIDUI sTz;

    WalletConfirmCardIDUI$2(WalletConfirmCardIDUI walletConfirmCardIDUI) {
        this.sTz = walletConfirmCardIDUI;
    }

    public final void onClick(View view) {
        if (!(WalletConfirmCardIDUI.a(this.sTz).isShown() || WalletConfirmCardIDUI.b(this.sTz))) {
            WalletConfirmCardIDUI.c(this.sTz).setVisibility(0);
            WalletConfirmCardIDUI.d(this.sTz).setVisibility(0);
        }
        WalletConfirmCardIDUI.e(this.sTz);
    }
}
