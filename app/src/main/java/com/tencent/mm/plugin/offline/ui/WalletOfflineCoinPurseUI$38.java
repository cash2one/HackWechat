package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.g.a.al;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$38 extends c<al> {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$38(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
        this.xen = al.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        al alVar = (al) bVar;
        if (a.oZq != 3 || !(alVar instanceof al) || !alVar.fox.foy) {
            return false;
        }
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "finish button event!");
        this.oYH.finish();
        return true;
    }
}
