package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ae.a$a;
import com.tencent.mm.protocal.c.aty;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class j$4 implements a<Void, a$a<aty>> {
    final /* synthetic */ b syv;
    final /* synthetic */ j syw;

    j$4(j jVar, b bVar) {
        this.syw = jVar;
        this.syv = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        return a((a$a) obj);
    }

    private Void a(a$a<aty> com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aty) {
        x.i("MicroMsg.LqtDetailInteractor", "lqtOnClickPurchase end, errType: %s, errCode: %s", Integer.valueOf(com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aty.errType), Integer.valueOf(com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aty.errCode));
        if (com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aty.errType == 0 && com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aty.errCode == 0) {
            i.syp.a(((aty) com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aty.fJJ).wBS, true);
        }
        this.syv.resume();
        return zBS;
    }
}
