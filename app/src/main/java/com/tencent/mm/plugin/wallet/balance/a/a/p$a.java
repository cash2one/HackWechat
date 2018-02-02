package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.o.5;
import com.tencent.mm.protocal.c.bbp;
import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class p$a implements e<bbp, d<Integer, Integer, ex>> {
    final /* synthetic */ p szd;

    public p$a(p pVar) {
        this.szd = pVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        o oVar = this.szd.syY;
        int intValue = ((Integer) dVar.get(0)).intValue();
        int intValue2 = ((Integer) dVar.get(1)).intValue();
        ex exVar = (ex) dVar.get(2);
        x.i("MicroMsg.LqtSaveFetchLogic", "fetchLqt, accountType: %s", new Object[]{Integer.valueOf(intValue2)});
        x.d("MicroMsg.LqtSaveFetchLogic", "fetchLqt, amount: %s, accountType: %s", new Object[]{Integer.valueOf(intValue), Integer.valueOf(intValue2)});
        oVar.syT = intValue;
        oVar.accountType = intValue2;
        oVar.syQ.agz();
        g.a(g.a(Integer.valueOf(intValue), exVar, Integer.valueOf(intValue2)).b(oVar.syP.syK).b(new 5(oVar)));
        return null;
    }

    public final String wx() {
        return "Vending.UI";
    }
}
