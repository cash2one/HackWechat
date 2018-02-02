package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.sdk.platformtools.ak.a;

class WalletOfflineCoinPurseUI$30 implements a {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$30(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
    }

    public final boolean uF() {
        if (!WalletOfflineCoinPurseUI.K(this.oYH)) {
            WalletOfflineCoinPurseUI.E(this.oYH);
            WalletOfflineCoinPurseUI.F(this.oYH);
        }
        long L = (long) WalletOfflineCoinPurseUI.L(this.oYH);
        WalletOfflineCoinPurseUI.M(this.oYH).J(L, L);
        return false;
    }
}
