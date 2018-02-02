package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.c.a;

class WalletOfflineCoinPurseUI$26 implements Runnable {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$26(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
    }

    public final void run() {
        c A = WalletOfflineCoinPurseUI.A(this.oYH);
        a.f(A.mActivity, A.oXI);
    }
}
