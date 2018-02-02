package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.ae.a$a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.x;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class a$1 implements a<Void, a$a<x>> {
    final /* synthetic */ b ihn;
    final /* synthetic */ a iho;

    a$1(a aVar, b bVar) {
        this.iho = aVar;
        this.ihn = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        a$a com_tencent_mm_ae_a_a = (a$a) obj;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish, errType: %s, errCode: %s", Integer.valueOf(com_tencent_mm_ae_a_a.errType), Integer.valueOf(com_tencent_mm_ae_a_a.errCode));
        if (com_tencent_mm_ae_a_a.errType == 0 && com_tencent_mm_ae_a_a.errCode == 0) {
            x xVar = (x) com_tencent_mm_ae_a_a.fJJ;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish, retcode: %s, retmsg: %s", Integer.valueOf(xVar.liH), xVar.liI);
            if (xVar.liH == 0) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.AAQueryListInteractor", "on AAQueryList finish get success, return record size: %s", Integer.valueOf(xVar.vDO.size()));
                this.iho.ihg += xVar.vDO.size();
                this.iho.ihh = xVar.vDK;
                this.iho.ihi = xVar.vDL;
                this.iho.ihj = xVar.vDM;
                this.iho.ihk = xVar.vDN;
                if (bh.ov(this.iho.ihh) || bh.ov(this.iho.ihk)) {
                    this.iho.ihl = false;
                } else {
                    this.iho.ihl = true;
                }
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AAQueryListInteractor", "bill_id: %s, trans_id %s", this.iho.ihh, this.iho.ihk);
                this.ihn.t(xVar.vDO, xVar.vDP, Boolean.valueOf(this.iho.ihl));
                g.pQN.a(407, 30, 1, false);
            } else if (xVar.liH <= 0 || !bh.ov(xVar.liI)) {
                this.ihn.cl(Boolean.valueOf(false));
                g.pQN.a(407, 32, 1, false);
            } else {
                this.ihn.cl(xVar.liI);
                g.pQN.a(407, 32, 1, false);
            }
        } else {
            this.ihn.cl(Boolean.valueOf(false));
            g.pQN.a(407, 31, 1, false);
        }
        return zBS;
    }
}
