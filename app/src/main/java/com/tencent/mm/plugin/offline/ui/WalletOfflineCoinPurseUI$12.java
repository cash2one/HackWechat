package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.g.a.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.e;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$12 extends c<cg> {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$12(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
        this.xen = cg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cg cgVar = (cg) bVar;
        x.d("MicroMsg.WalletOfflineCoinPurseUI", "do offline showcode");
        k.bgX();
        k.bgZ();
        com.tencent.mm.ae.k oVar = new o(e.bgQ(), WalletOfflineCoinPurseUI.b(this.oYH), cgVar.fqz.fqA);
        g.Dk();
        g.Di().gPJ.a(oVar, 0);
        return false;
    }
}
