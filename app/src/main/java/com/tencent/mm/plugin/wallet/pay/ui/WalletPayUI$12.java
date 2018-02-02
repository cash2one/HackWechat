package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.sdk.platformtools.x;

class WalletPayUI$12 implements Runnable {
    final /* synthetic */ WalletPayUI sGh;

    WalletPayUI$12(WalletPayUI walletPayUI) {
        this.sGh = walletPayUI;
    }

    public final void run() {
        x.i("MicroMsg.WalletPayUI", "auto reset create flag");
        WalletPayUI.akQ();
    }
}
