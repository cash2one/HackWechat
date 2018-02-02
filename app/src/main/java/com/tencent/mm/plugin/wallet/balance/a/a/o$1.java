package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.g;

class o$1 implements a {
    final /* synthetic */ o syW;

    o$1(o oVar) {
        this.syW = oVar;
    }

    public final void aW(Object obj) {
        x.i("MicroMsg.LqtSaveFetchLogic", "onInterrupt %s", new Object[]{obj});
        o.a(this.syW).bJB();
        g.czQ().cl(obj);
    }
}
