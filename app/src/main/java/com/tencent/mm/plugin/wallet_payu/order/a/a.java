package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.protocal.c.awn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class a extends l {
    public b gJQ;
    private e gJT;

    public a(int i) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new awm();
        aVar.hmk = new awn();
        aVar.uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
        aVar.hmi = 1519;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        awm com_tencent_mm_protocal_c_awm = (awm) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_awm.niE = 10;
        com_tencent_mm_protocal_c_awm.vNW = i;
        x.d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10" + ",offset:" + i);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.gJT.a(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((awn) ((b) qVar).hmh.hmo).wEf);
        }
    }

    public final int bNu() {
        return ((awn) this.gJQ.hmh.hmo).wEf;
    }

    public final int getType() {
        return 1519;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
