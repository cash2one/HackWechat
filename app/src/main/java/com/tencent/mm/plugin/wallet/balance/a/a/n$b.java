package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.m.2;
import com.tencent.mm.protocal.c.azm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class n$b implements e<azm, com.tencent.mm.vending.j.e<String, String, Integer, Integer>> {
    final /* synthetic */ n syL;

    public n$b(n nVar) {
        this.syL = nVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
        m mVar = this.syL.syG;
        String str = (String) eVar.get(0);
        String str2 = (String) eVar.get(1);
        int intValue = ((Integer) eVar.get(2)).intValue();
        x.i("MicroMsg.LqtSaveFetchInteractor", "do lqtQueryPurchaseResult, tradeNo: %s, transactionId: %s, accountType: %s", new Object[]{str, str2, Integer.valueOf(((Integer) eVar.get(3)).intValue())});
        x.d("MicroMsg.LqtSaveFetchInteractor", "do lqtQueryPurchaseResult, tradeNo: %s, transactionId: %s, purchaseFee: %s", new Object[]{str, str2, Integer.valueOf(intValue)});
        b czQ = g.czQ();
        czQ.czP();
        new f(str, str2, intValue, r2).JV().h(new 2(mVar, czQ));
        return null;
    }

    public final String wx() {
        return "Vending.UI";
    }
}
