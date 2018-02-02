package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.plugin.wallet.balance.ui.lqt.a.a;
import com.tencent.mm.wallet_core.ui.e;

class WalletLqtSaveFetchUI$9 implements a {
    final /* synthetic */ int sBA;
    final /* synthetic */ WalletLqtSaveFetchUI sBv;

    WalletLqtSaveFetchUI$9(WalletLqtSaveFetchUI walletLqtSaveFetchUI, int i) {
        this.sBv = walletLqtSaveFetchUI;
        this.sBA = i;
    }

    public final void WO() {
        WalletLqtSaveFetchUI.c(this.sBv).setText(e.t(WalletLqtSaveFetchUI.ey(this.sBA, "100")));
    }
}
