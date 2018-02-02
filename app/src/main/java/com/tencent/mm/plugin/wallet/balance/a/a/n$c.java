package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.m.3;
import com.tencent.mm.protocal.c.bbp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class n$c implements e<bbp, com.tencent.mm.vending.j.e<Integer, String, String, Integer>> {
    final /* synthetic */ n syL;

    public n$c(n nVar) {
        this.syL = nVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
        m mVar = this.syL.syG;
        int intValue = ((Integer) eVar.get(0)).intValue();
        String str = (String) eVar.get(1);
        x.i("MicroMsg.LqtSaveFetchInteractor", "do lqtRedeemFund, redeemListId: %s, accountType: %s", new Object[]{(String) eVar.get(2), Integer.valueOf(((Integer) eVar.get(3)).intValue())});
        x.d("MicroMsg.LqtSaveFetchInteractor", "do lqtRedeemFund, redeemFee: %s, payPasswdEnc: %s, redeemListId: %s", new Object[]{Integer.valueOf(intValue), str, r1});
        b czQ = g.czQ();
        czQ.czP();
        new h(intValue, str, r1, r2).JV().h(new 3(mVar, czQ));
        return null;
    }

    public final String wx() {
        return "Vending.UI";
    }
}
