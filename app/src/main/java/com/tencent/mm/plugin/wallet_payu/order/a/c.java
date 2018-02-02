package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.awj;
import com.tencent.mm.protocal.c.awt;
import com.tencent.mm.protocal.c.awu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class c extends l {
    private b gJQ;
    private e gJT;
    public awj tcw = null;

    public c(String str) {
        a aVar = new a();
        aVar.hmj = new awt();
        aVar.hmk = new awu();
        aVar.uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
        aVar.hmi = 1520;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        awt com_tencent_mm_protocal_c_awt = (awt) this.gJQ.hmg.hmo;
        if (!bh.ov(str)) {
            com_tencent_mm_protocal_c_awt.pbi = str;
        }
    }

    public final int getType() {
        return 1520;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.gJT.a(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            awu com_tencent_mm_protocal_c_awu = (awu) ((b) qVar).hmh.hmo;
            this.tcw = com_tencent_mm_protocal_c_awu.wEi;
            if (com_tencent_mm_protocal_c_awu.wEi != null) {
                x.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + com_tencent_mm_protocal_c_awu.wEi.pbi);
            } else {
                x.e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
            }
        }
    }
}
