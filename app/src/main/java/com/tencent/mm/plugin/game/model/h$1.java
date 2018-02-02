package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class h$1 implements e {
    final /* synthetic */ String jde;

    h$1(String str) {
        this.jde = str;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.GameCommOpertionProcessor", "pull menu data success. appid:%s", new Object[]{this.jde});
            ar.CG().b(1369, this);
            final ajq com_tencent_mm_protocal_c_ajq = (ajq) ((bf) kVar).lMW.hmh.hmo;
            ag.y(new Runnable(this) {
                final /* synthetic */ h$1 nbA;

                public final void run() {
                    h.a(com_tencent_mm_protocal_c_ajq, this.nbA.jde);
                }
            });
            return;
        }
        x.i("MicroMsg.GameCommOpertionProcessor", "pull menu data fail. appid:%s", new Object[]{this.jde});
    }
}
