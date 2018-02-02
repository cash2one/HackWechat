package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class p$b implements e<x, Integer> {
    final /* synthetic */ p szd;

    public p$b(p pVar) {
        this.szd = pVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        Integer num = (Integer) obj;
        o oVar = this.szd.syY;
        int intValue = num.intValue();
        oVar.igh = g.czQ();
        oVar.igh.czP();
        oVar.syQ.b(new x(null, intValue == 1 ? 24 : 25), true);
        return null;
    }

    public final String wx() {
        return "Vending.UI";
    }
}
