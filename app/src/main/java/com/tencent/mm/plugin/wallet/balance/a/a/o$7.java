package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.azm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class o$7 implements a<Void, azm> {
    final /* synthetic */ o syW;

    public o$7(o oVar) {
        this.syW = oVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        azm com_tencent_mm_protocal_c_azm = (azm) obj;
        x.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult finish: %s", new Object[]{com_tencent_mm_protocal_c_azm});
        o.a(this.syW).bJB();
        o.a(this.syW).bJC();
        if (o.c(this.syW) != null) {
            o.c(this.syW).t(new Object[]{com_tencent_mm_protocal_c_azm});
        }
        return zBS;
    }
}
