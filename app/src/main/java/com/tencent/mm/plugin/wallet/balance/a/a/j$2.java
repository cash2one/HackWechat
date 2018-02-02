package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.ae.a$a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.oj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class j$2 implements a<Void, a$a<oj>> {
    final /* synthetic */ b syv;
    final /* synthetic */ j syw;

    j$2(j jVar, b bVar) {
        this.syw = jVar;
        this.syv = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        a$a com_tencent_mm_ae_a_a = (a$a) obj;
        x.i("MicroMsg.LqtDetailInteractor", "on close lqt account finish, errType: %s, errCode: %s", Integer.valueOf(com_tencent_mm_ae_a_a.errType), Integer.valueOf(com_tencent_mm_ae_a_a.errCode));
        j.bJm();
        if (com_tencent_mm_ae_a_a.errType == 0 && com_tencent_mm_ae_a_a.errCode == 0) {
            oj ojVar = (oj) com_tencent_mm_ae_a_a.fJJ;
            x.i("MicroMsg.LqtDetailInteractor", "on close lqt account finsih, retcode: %s, retmsg: %s", Integer.valueOf(ojVar.kLO), ojVar.kLP);
            if (ojVar.kLO == 0) {
                this.syv.t(ojVar);
                g.pQN.a(663, 15, 1, false);
            } else {
                this.syv.cl(ojVar.kLP);
                g.pQN.a(663, 16, 1, false);
            }
        } else {
            this.syv.cl(Boolean.valueOf(false));
            g.pQN.a(663, 17, 1, false);
        }
        return zBS;
    }
}
