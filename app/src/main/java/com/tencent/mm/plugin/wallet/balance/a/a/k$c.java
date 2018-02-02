package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.aty;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class k$c implements e<aty, Integer> {
    final /* synthetic */ k syC;

    public k$c(k kVar) {
        this.syC = kVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        Integer num = (Integer) obj;
        j jVar = this.syC.syx;
        x.i("MicroMsg.LqtDetailInteractor", "lqtOnClickPurchase, accountType: %s", Integer.valueOf(num.intValue()));
        b czQ = g.czQ();
        czQ.czP();
        new b(r1).JV().h(new j$4(jVar, czQ));
        return null;
    }

    public final String wx() {
        return "Vending.UI";
    }
}
