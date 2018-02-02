package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bbp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class m$3 implements a<Void, com.tencent.mm.ae.a.a<bbp>> {
    final /* synthetic */ m syF;
    final /* synthetic */ b syv;

    m$3(m mVar, b bVar) {
        this.syF = mVar;
        this.syv = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ae.a.a aVar = (com.tencent.mm.ae.a.a) obj;
        x.i("MicroMsg.LqtSaveFetchInteractor", "on redeem fund finish, cgiBack: %s, errType: %s, errCode: %s", new Object[]{aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            bbp com_tencent_mm_protocal_c_bbp = (bbp) aVar.fJJ;
            x.i("MicroMsg.LqtSaveFetchInteractor", "on redeem fund finsih, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bbp.kLO), com_tencent_mm_protocal_c_bbp.kLP});
            if (com_tencent_mm_protocal_c_bbp.kLO == 0) {
                this.syv.t(new Object[]{com_tencent_mm_protocal_c_bbp});
                g.pQN.a(663, 12, 1, false);
            } else {
                this.syv.cl(com_tencent_mm_protocal_c_bbp.kLP);
                g.pQN.a(663, 13, 1, false);
            }
        } else {
            this.syv.cl(Boolean.valueOf(false));
            g.pQN.a(663, 14, 1, false);
        }
        return zBS;
    }
}
