package com.tencent.mm.plugin.wallet.balance.ui;

class WalletBalanceFetchUI$18 implements Runnable {
    final /* synthetic */ int pJx;
    final /* synthetic */ WalletBalanceFetchUI szH;

    WalletBalanceFetchUI$18(WalletBalanceFetchUI walletBalanceFetchUI, int i) {
        this.szH = walletBalanceFetchUI;
        this.pJx = i;
    }

    public final void run() {
        WalletBalanceFetchUI.i(this.szH).scrollBy(0, this.pJx);
    }
}
