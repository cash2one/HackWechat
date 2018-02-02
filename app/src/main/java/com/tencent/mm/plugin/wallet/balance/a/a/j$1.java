package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.azo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class j$1 implements a<Void, com.tencent.mm.ae.a.a<azo>> {
    final /* synthetic */ b syv;
    final /* synthetic */ j syw;

    j$1(j jVar, b bVar) {
        this.syw = jVar;
        this.syv = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ae.a.a aVar = (com.tencent.mm.ae.a.a) obj;
        x.i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finish, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            azo com_tencent_mm_protocal_c_azo = (azo) aVar.fJJ;
            x.i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azo.kLO), com_tencent_mm_protocal_c_azo.kLP});
            if (com_tencent_mm_protocal_c_azo.kLO == 0) {
                this.syv.t(new Object[]{com_tencent_mm_protocal_c_azo});
                g.pQN.a(663, 0, 1, false);
            } else {
                this.syv.cl(com_tencent_mm_protocal_c_azo.kLP);
                g.pQN.a(663, 1, 1, false);
            }
        } else {
            this.syv.cl(Boolean.valueOf(false));
            g.pQN.a(663, 2, 1, false);
        }
        return zBS;
    }
}
