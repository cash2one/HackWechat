package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.aa.a.a.j;
import com.tencent.mm.plugin.aa.a.b.c;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;

public final class b implements e {
    com.tencent.mm.vending.g.b igh;

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            v vVar = ((j) kVar).ihd;
            x.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", Integer.valueOf(vVar.liH));
            if (vVar.liH == 0) {
                g.a(this.igh, vVar);
                com.tencent.mm.plugin.report.service.g.pQN.a(407, 6, 1, false);
                c oD = com.tencent.mm.plugin.aa.b.WA().oD(vVar.vCW);
                if (oD != null) {
                    oD.field_status = vVar.state;
                    com.tencent.mm.plugin.aa.b.WA().b(oD);
                    return;
                }
                return;
            }
            if (vVar.liH <= 0 || bh.ov(vVar.liI)) {
                this.igh.cl(Boolean.valueOf(false));
            } else {
                this.igh.cl(vVar.liI);
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(407, 8, 1, false);
            return;
        }
        if (this.igh != null) {
            this.igh.cl(Boolean.valueOf(false));
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(407, 7, 1, false);
    }
}
