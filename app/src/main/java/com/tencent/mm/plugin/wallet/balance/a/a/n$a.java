package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.axt;
import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class n$a implements e<axt, d<Integer, ex, Integer>> {
    final /* synthetic */ n syL;

    public n$a(n nVar) {
        this.syL = nVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        m mVar = this.syL.syG;
        int intValue = ((Integer) dVar.get(0)).intValue();
        ex exVar = (ex) dVar.get(1);
        x.i("MicroMsg.LqtSaveFetchInteractor", "do lqtPreRedeemFund, accountType: %s", new Object[]{Integer.valueOf(((Integer) dVar.get(2)).intValue())});
        x.d("MicroMsg.LqtSaveFetchInteractor", "do lqtPreRedeemFund, redeemFee: %s", new Object[]{Integer.valueOf(intValue)});
        b czQ = g.czQ();
        czQ.czP();
        new d(intValue, exVar, r1).JV().h(new m$4(mVar, czQ));
        return null;
    }

    public final String wx() {
        return "Vending.UI";
    }
}
