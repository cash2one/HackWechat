package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;

public final class i implements e {
    long fqm = -1;
    b hmc;

    public final void init() {
        g.Dk();
        g.Di().gPJ.a(1530, this);
    }

    public final void WK() {
        g.Dk();
        g.Di().gPJ.b(1530, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            com.tencent.mm.protocal.c.e eVar = ((com.tencent.mm.plugin.aa.a.a.e) kVar).igT;
            x.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", new Object[]{Integer.valueOf(eVar.liH)});
            x.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", new Object[]{eVar.vCY});
            if (eVar.liH == 0) {
                com.tencent.mm.vending.g.g.a(this.hmc, new Object[]{Boolean.valueOf(true)});
                if (!bh.ov(eVar.vCY) && this.fqm > 0 && ((com.tencent.mm.plugin.aa.a.a.e) kVar).scene == a.igd) {
                    h.h(this.fqm, eVar.vCY);
                }
                com.tencent.mm.plugin.report.service.g.pQN.a(407, 21, 1, false);
                return;
            } else if (eVar.liH <= 0 || bh.ov(eVar.liI)) {
                this.hmc.cl(Boolean.valueOf(false));
                com.tencent.mm.plugin.report.service.g.pQN.a(407, 23, 1, false);
                return;
            } else {
                this.hmc.cl(eVar.liI);
                com.tencent.mm.plugin.report.service.g.pQN.a(407, 11, 1, false);
                return;
            }
        }
        this.hmc.cl(Boolean.valueOf(false));
        com.tencent.mm.plugin.report.service.g.pQN.a(407, 22, 1, false);
    }
}
