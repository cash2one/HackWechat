package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.ayx;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class n$d implements e<ayx, d<String, Integer, Integer>> {
    final /* synthetic */ n syL;

    public n$d(n nVar) {
        this.syL = nVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        m mVar = this.syL.syG;
        String str = (String) dVar.get(0);
        int intValue = ((Integer) dVar.get(1)).intValue();
        x.i("MicroMsg.LqtSaveFetchInteractor", "do lqtSave, fundCode: %s, accountType: %s", new Object[]{str, Integer.valueOf(((Integer) dVar.get(2)).intValue())});
        x.d("MicroMsg.LqtSaveFetchInteractor", "do lqtSave, fundCode: %s, purchaseFee: %s", new Object[]{str, Integer.valueOf(intValue)});
        b czQ = g.czQ();
        czQ.czP();
        new e(str, intValue, r1).JV().h(new m$1(mVar, czQ));
        return null;
    }

    public final String wx() {
        return "Vending.UI";
    }
}
