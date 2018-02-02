package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.axt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class m$4 implements a<Void, com.tencent.mm.ae.a.a<axt>> {
    final /* synthetic */ m syF;
    final /* synthetic */ b syv;

    m$4(m mVar, b bVar) {
        this.syF = mVar;
        this.syv = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ae.a.a aVar = (com.tencent.mm.ae.a.a) obj;
        x.i("MicroMsg.LqtSaveFetchInteractor", "on pre redeem fund finish, cgiBack: %s, errType: %s, errCode: %s", new Object[]{aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            axt com_tencent_mm_protocal_c_axt = (axt) aVar.fJJ;
            x.i("MicroMsg.LqtSaveFetchInteractor", "on pre redeem fund finsih, retcode: %s, retmsg: %s, redeem_listid: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_axt.kLO), com_tencent_mm_protocal_c_axt.kLP, com_tencent_mm_protocal_c_axt.wER});
            if (com_tencent_mm_protocal_c_axt.kLO == 0) {
                this.syv.t(new Object[]{com_tencent_mm_protocal_c_axt});
                g.pQN.a(663, 9, 1, false);
            } else {
                this.syv.cl(com_tencent_mm_protocal_c_axt.kLP);
                g.pQN.a(663, 10, 1, false);
            }
        } else {
            this.syv.cl(Boolean.valueOf(false));
            g.pQN.a(663, 11, 1, false);
        }
        return zBS;
    }
}
