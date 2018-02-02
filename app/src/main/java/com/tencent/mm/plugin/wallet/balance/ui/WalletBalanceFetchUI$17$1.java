package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.17;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class WalletBalanceFetchUI$17$1 implements c {
    final /* synthetic */ 17 szO;

    WalletBalanceFetchUI$17$1(17 17) {
        this.szO = 17;
    }

    public final void a(n nVar) {
        int i = 0;
        b.c[] cVarArr = this.szO.szN.sKN.sKP;
        int length = cVarArr.length;
        int i2 = 0;
        while (i < length) {
            b.c cVar = cVarArr[i];
            if (!bh.ov(cVar.title)) {
                if (bh.ov(cVar.desc)) {
                    nVar.f(i2, cVar.title);
                } else {
                    nVar.a(i2, cVar.title, cVar.desc);
                }
            }
            i2++;
            i++;
        }
    }
}
