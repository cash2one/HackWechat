package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ae.a$a;
import com.tencent.mm.protocal.c.aty;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class o$10 implements a<Void, a$a<aty>> {
    final /* synthetic */ o syW;

    o$10(o oVar) {
        this.syW = oVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        return a((a$a) obj);
    }

    private Void a(a$a<aty> com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aty) {
        x.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", Integer.valueOf(com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aty.errType), Integer.valueOf(com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aty.errCode));
        if (com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aty.errType == 0 && com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aty.errCode == 0) {
            i.syp.a(((aty) com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aty.fJJ).wBS, true);
        }
        if (o.c(this.syW) != null) {
            o.c(this.syW).resume();
        }
        return zBS;
    }
}
