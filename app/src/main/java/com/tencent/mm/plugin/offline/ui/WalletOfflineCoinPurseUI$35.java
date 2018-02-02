package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.g.a.kr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$35 extends c<kr> {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$35(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
        this.xen = kr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (((kr) bVar).fCc.aen != hashCode()) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "has create a new ui, finish self");
            this.oYH.finish();
        }
        return false;
    }
}
