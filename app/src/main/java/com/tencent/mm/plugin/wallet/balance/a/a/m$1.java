package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ayx;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class m$1 implements a<Void, com.tencent.mm.ae.a.a<ayx>> {
    final /* synthetic */ m syF;
    final /* synthetic */ b syv;

    m$1(m mVar, b bVar) {
        this.syF = mVar;
        this.syv = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ae.a.a aVar = (com.tencent.mm.ae.a.a) obj;
        x.i("MicroMsg.LqtSaveFetchInteractor", "on purchaseFund finish, cgiBack: %s, errType: %s, errCode: %s", new Object[]{aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            ayx com_tencent_mm_protocal_c_ayx = (ayx) aVar.fJJ;
            x.i("MicroMsg.LqtSaveFetchInteractor", "on purchaseFund finsih, retcode: %s, retmsg: %s, prepayid: %s, out_trade_no: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ayx.kLO), com_tencent_mm_protocal_c_ayx.kLP, com_tencent_mm_protocal_c_ayx.wFW, com_tencent_mm_protocal_c_ayx.vDr});
            if (com_tencent_mm_protocal_c_ayx.kLO == 0) {
                this.syv.t(new Object[]{aVar.fJJ});
                g.pQN.a(663, 3, 1, false);
            } else {
                this.syv.cl(com_tencent_mm_protocal_c_ayx.kLP);
                g.pQN.a(664, 4, 1, false);
            }
        } else {
            this.syv.cl(Boolean.valueOf(false));
            g.pQN.a(664, 5, 1, false);
        }
        return zBS;
    }
}
