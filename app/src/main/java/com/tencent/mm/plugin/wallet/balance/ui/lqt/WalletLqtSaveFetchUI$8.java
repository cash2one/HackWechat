package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.wallet_core.ui.e;

class WalletLqtSaveFetchUI$8 implements a$a {
    final /* synthetic */ int sBA;
    final /* synthetic */ WalletLqtSaveFetchUI sBv;

    WalletLqtSaveFetchUI$8(WalletLqtSaveFetchUI walletLqtSaveFetchUI, int i) {
        this.sBv = walletLqtSaveFetchUI;
        this.sBA = i;
    }

    public final void WO() {
        WalletLqtSaveFetchUI.c(this.sBv).setText(e.t(WalletLqtSaveFetchUI.ey(this.sBA, "100")));
    }
}
