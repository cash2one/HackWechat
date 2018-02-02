package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.o.4;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.c.azm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class p$c implements e<azm, d<Integer, Integer, Bankcard>> {
    final /* synthetic */ p szd;

    public p$c(p pVar) {
        this.szd = pVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        o oVar = this.szd.syY;
        int intValue = ((Integer) dVar.get(0)).intValue();
        int intValue2 = ((Integer) dVar.get(1)).intValue();
        Bankcard bankcard = (Bankcard) dVar.get(2);
        String str = "MicroMsg.LqtSaveFetchLogic";
        String str2 = "saveLqt, accountType: %s, bankcard: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(intValue2);
        objArr[1] = bankcard != null ? bankcard.field_bindSerial : "";
        x.i(str, str2, objArr);
        x.d("MicroMsg.LqtSaveFetchLogic", "saveLqt, amount: %s", new Object[]{Integer.valueOf(intValue)});
        String stringExtra = oVar.syQ.getIntent().getStringExtra("lqt_save_fund_code");
        oVar.syS = intValue;
        oVar.accountType = intValue2;
        oVar.syQ.agz();
        g.a(g.a(stringExtra, Integer.valueOf(intValue), Integer.valueOf(intValue2)).b(oVar.syP.syH).b(new 4(oVar)).b(new o$3(oVar, bankcard)).a(new o$1(oVar)));
        return null;
    }

    public final String wx() {
        return "Vending.UI";
    }
}
