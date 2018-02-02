package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;

class o$8 implements a {
    final /* synthetic */ o syW;

    public o$8(o oVar) {
        this.syW = oVar;
    }

    public final void aW(Object obj) {
        x.i("MicroMsg.LqtSaveFetchLogic", "doRedeemFund interrupt: %s", new Object[]{obj});
        o.a(this.syW).bJB();
        if (o.c(this.syW) != null) {
            o.c(this.syW).cl(obj);
        }
    }
}
