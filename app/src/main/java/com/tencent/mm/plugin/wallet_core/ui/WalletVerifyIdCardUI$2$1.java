package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI.2;

class WalletVerifyIdCardUI$2$1 implements Runnable {
    final /* synthetic */ boolean sWV;
    final /* synthetic */ 2 sWW;

    WalletVerifyIdCardUI$2$1(2 2, boolean z) {
        this.sWW = 2;
        this.sWV = z;
    }

    public final void run() {
        if (this.sWV && !WalletVerifyIdCardUI.a(this.sWW.sWU, WalletVerifyIdCardUI.a(this.sWW.sWU))) {
            WalletVerifyIdCardUI.b(this.sWW.sWU);
        }
    }
}
