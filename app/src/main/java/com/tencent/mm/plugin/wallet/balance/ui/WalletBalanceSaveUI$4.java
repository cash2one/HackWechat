package com.tencent.mm.plugin.wallet.balance.ui;

class WalletBalanceSaveUI$4 implements Runnable {
    final /* synthetic */ int pJx;
    final /* synthetic */ WalletBalanceSaveUI sAi;

    WalletBalanceSaveUI$4(WalletBalanceSaveUI walletBalanceSaveUI, int i) {
        this.sAi = walletBalanceSaveUI;
        this.pJx = i;
    }

    public final void run() {
        WalletBalanceSaveUI.e(this.sAi).scrollBy(0, this.pJx);
    }
}
