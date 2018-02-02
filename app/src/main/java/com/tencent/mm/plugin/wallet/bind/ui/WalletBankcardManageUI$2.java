package com.tencent.mm.plugin.wallet.bind.ui;

import com.tencent.mm.plugin.wallet_core.ui.o.a;

class WalletBankcardManageUI$2 implements a {
    final /* synthetic */ WalletBankcardManageUI sCF;
    final /* synthetic */ Runnable sCG;

    WalletBankcardManageUI$2(WalletBankcardManageUI walletBankcardManageUI, Runnable runnable) {
        this.sCF = walletBankcardManageUI;
        this.sCG = runnable;
    }

    public final void aYr() {
        this.sCG.run();
    }

    public final void cancel() {
        WalletBankcardManageUI.c(this.sCF).fpa = false;
    }

    public final void aYs() {
        this.sCG.run();
    }
}
