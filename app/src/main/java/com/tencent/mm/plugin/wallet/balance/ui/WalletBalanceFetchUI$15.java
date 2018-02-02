package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.wallet_core.ui.a;

class WalletBalanceFetchUI$15 implements a {
    final /* synthetic */ WalletBalanceFetchUI szH;

    WalletBalanceFetchUI$15(WalletBalanceFetchUI walletBalanceFetchUI) {
        this.szH = walletBalanceFetchUI;
    }

    public final void hA(boolean z) {
        if (z) {
            WalletBalanceFetchUI.h(this.szH);
        } else {
            WalletBalanceFetchUI.i(this.szH).scrollTo(0, 0);
        }
    }
}
