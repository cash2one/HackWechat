package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.g.a.ph;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class WalletOfflineCoinPurseUI$36 extends c<ph> {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$36(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
        this.xen = ph.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!this.oYH.isFinishing()) {
            this.oYH.finish();
        }
        return false;
    }
}
