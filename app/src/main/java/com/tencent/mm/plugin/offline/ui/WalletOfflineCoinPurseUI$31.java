package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.g;
import com.tencent.mm.sdk.platformtools.ak.a;

class WalletOfflineCoinPurseUI$31 implements a {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$31(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
    }

    public final boolean uF() {
        WalletOfflineCoinPurseUI.a(this.oYH);
        if (WalletOfflineCoinPurseUI.o(this.oYH) != null && WalletOfflineCoinPurseUI.o(this.oYH).isShowing()) {
            WalletOfflineCoinPurseUI.o(this.oYH).dismiss();
        }
        g.bgT();
        WalletOfflineCoinPurseUI.N(this.oYH);
        if (com.tencent.mm.plugin.offline.c.a.bij()) {
            this.oYH.bhl();
        }
        return false;
    }
}
