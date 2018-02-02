package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.bbp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class o$9 implements a<Void, bbp> {
    final /* synthetic */ o syW;

    public o$9(o oVar) {
        this.syW = oVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        bbp com_tencent_mm_protocal_c_bbp = (bbp) obj;
        x.i("MicroMsg.LqtSaveFetchLogic", "doRedeemFund finish: %s", new Object[]{com_tencent_mm_protocal_c_bbp});
        o.a(this.syW).bJB();
        o.a(this.syW).bJC();
        if (o.c(this.syW) != null) {
            o.c(this.syW).t(new Object[]{com_tencent_mm_protocal_c_bbp});
        }
        return zBS;
    }
}
