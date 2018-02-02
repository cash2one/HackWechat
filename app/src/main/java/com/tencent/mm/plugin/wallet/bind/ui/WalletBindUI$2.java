package com.tencent.mm.plugin.wallet.bind.ui;

import com.tencent.mm.plugin.wallet_core.model.ae;

class WalletBindUI$2 implements Runnable {
    final /* synthetic */ WalletBindUI sCR;

    WalletBindUI$2(WalletBindUI walletBindUI) {
        this.sCR = walletBindUI;
    }

    public final void run() {
        if (!WalletBindUI.a(this.sCR)) {
            if (WalletBindUI.b(this.sCR) == 4) {
                WalletBindUI.d(this.sCR).a(new 1(this), new ae().bLI());
            } else {
                WalletBindUI.c(this.sCR);
            }
            if (!WalletBindUI.a(this.sCR)) {
                WalletBindUI.e(this.sCR);
            }
        }
    }
}
