package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;

public final class f implements e {
    b igh;
    boolean igv = false;

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.igv = false;
        if (i == 0 && i2 == 0) {
            o oVar = ((i) kVar).ihb;
            x.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(oVar.liH), oVar.liI});
            if (oVar.liH == 0) {
                g.a(this.igh, new Object[]{oVar});
                com.tencent.mm.plugin.report.service.g.pQN.a(407, 9, 1, false);
                return;
            }
            if (this.igh != null) {
                if (oVar.vDq != null && oVar.vDq.fDt == 1 && !bh.ov(oVar.vDq.liO) && !bh.ov(oVar.vDq.odw) && !bh.ov(oVar.vDq.odx) && !bh.ov(oVar.vDq.fyY)) {
                    this.igh.cl(oVar.vDq);
                } else if (oVar.liH <= 0 || bh.ov(oVar.liI)) {
                    this.igh.cl(Boolean.valueOf(false));
                } else {
                    this.igh.cl(oVar.liI);
                }
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(407, 11, 1, false);
            return;
        }
        if (this.igh != null) {
            this.igh.cl(Boolean.valueOf(false));
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(407, 10, 1, false);
    }
}
