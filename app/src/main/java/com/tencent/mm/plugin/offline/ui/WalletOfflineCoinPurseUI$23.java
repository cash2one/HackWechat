package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.g.a.le;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$23 extends c<le> {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$23(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
        this.xen = le.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", " ecard finish: %s", new Object[]{Integer.valueOf(((le) bVar).fCv.retCode)});
        this.oYH.b(new com.tencent.mm.plugin.wallet_core.c.x(null, 8), false);
        return false;
    }
}
