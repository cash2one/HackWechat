package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.protocal.c.awq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class b extends l {
    private com.tencent.mm.ae.b gJQ;
    private e gJT;

    public b(String str) {
        a aVar = new a();
        aVar.hmj = new awp();
        aVar.hmk = new awq();
        aVar.uri = "/cgi-bin/mmpay-bin/payudeluserroll";
        aVar.hmi = 1544;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        awp com_tencent_mm_protocal_c_awp = (awp) this.gJQ.hmg.hmo;
        if (!bh.ov(str)) {
            com_tencent_mm_protocal_c_awp.pbi = str;
        }
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePayUDelUserRoll", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gJT.a(i, i2, str, this);
    }

    public final int getType() {
        return 1544;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
