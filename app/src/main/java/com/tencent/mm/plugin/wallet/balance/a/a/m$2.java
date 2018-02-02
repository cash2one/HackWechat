package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.azm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class m$2 implements a<Void, com.tencent.mm.ae.a.a<azm>> {
    final /* synthetic */ m syF;
    final /* synthetic */ b syv;

    m$2(m mVar, b bVar) {
        this.syF = mVar;
        this.syv = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ae.a.a aVar = (com.tencent.mm.ae.a.a) obj;
        x.i("MicroMsg.LqtSaveFetchInteractor", "on qry purchase result finish, cgiBack: %s, errType: %s, errCode: %s", new Object[]{aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            azm com_tencent_mm_protocal_c_azm = (azm) aVar.fJJ;
            x.i("MicroMsg.LqtSaveFetchInteractor", "on qry purchase result finsih, retcode: %s, retmsg: %s, purchase_state: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azm.kLO), com_tencent_mm_protocal_c_azm.kLP, Integer.valueOf(com_tencent_mm_protocal_c_azm.wGy)});
            if (com_tencent_mm_protocal_c_azm.kLO == 0) {
                this.syv.t(new Object[]{com_tencent_mm_protocal_c_azm});
                g.pQN.a(663, 6, 1, false);
            } else {
                this.syv.cl(com_tencent_mm_protocal_c_azm.kLP);
                g.pQN.a(663, 7, 1, false);
            }
        } else {
            this.syv.cl(Boolean.valueOf(false));
            g.pQN.a(663, 8, 1, false);
        }
        return zBS;
    }
}
