package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ae.a$a;
import com.tencent.mm.protocal.c.aua;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class j$3 implements a<Void, a$a<aua>> {
    final /* synthetic */ b syv;
    final /* synthetic */ j syw;

    j$3(j jVar, b bVar) {
        this.syw = jVar;
        this.syv = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        return a((a$a) obj);
    }

    private Void a(a$a<aua> com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aua) {
        x.i("MicroMsg.LqtDetailInteractor", "lqtOnClickRedeem end, errType: %s, errCode: %s", Integer.valueOf(com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aua.errType), Integer.valueOf(com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aua.errCode));
        if (com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aua.errType == 0 && com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aua.errCode == 0) {
            l.bJn().a((aua) com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aua.fJJ);
            i.syp.a(((aua) com_tencent_mm_ae_a_a_com_tencent_mm_protocal_c_aua.fJJ).wBS, false);
        }
        this.syv.resume();
        return zBS;
    }
}
