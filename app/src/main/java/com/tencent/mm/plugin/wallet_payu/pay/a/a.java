package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class a extends l {
    private b gJQ;
    private e gJT;

    public final int getType() {
        return 1554;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePayUCheckJsApi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        awo com_tencent_mm_protocal_c_awo = (awo) ((b) qVar).hmh.hmo;
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetScenePayUCheckJsApi", "rr " + com_tencent_mm_protocal_c_awo.lOr);
        }
        this.gJT.a(i, i2, com_tencent_mm_protocal_c_awo.lOs, this);
    }
}
