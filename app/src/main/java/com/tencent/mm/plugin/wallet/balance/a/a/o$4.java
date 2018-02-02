package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.ayx;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class o$4 implements a<ayx, ayx> {
    final /* synthetic */ o syW;

    o$4(o oVar) {
        this.syW = oVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        ayx com_tencent_mm_protocal_c_ayx = (ayx) obj;
        o.a(this.syW, com_tencent_mm_protocal_c_ayx.vDr);
        o.a(this.syW).bJB();
        x.i("MicroMsg.LqtSaveFetchLogic", "get tradeNo: %s", new Object[]{o.b(this.syW)});
        return com_tencent_mm_protocal_c_ayx;
    }
}
