package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.biu;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bmm;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends com.tencent.mm.wallet_core.c.l implements k {
    private b gJQ;
    private e gJT;
    public String pej;

    public l(biu com_tencent_mm_protocal_c_biu, String str) {
        a aVar = new a();
        aVar.hmj = new bml();
        aVar.hmk = new bmm();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallorder";
        this.gJQ = aVar.JZ();
        bml com_tencent_mm_protocal_c_bml = (bml) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bml.wPP = com_tencent_mm_protocal_c_biu;
        com_tencent_mm_protocal_c_bml.wPR = str;
    }

    public final int getType() {
        return 556;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        bmm com_tencent_mm_protocal_c_bmm = (bmm) ((b) qVar).hmh.hmo;
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + com_tencent_mm_protocal_c_bmm.wPQ);
            this.pej = com_tencent_mm_protocal_c_bmm.wPQ;
        }
        x.d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + i2 + ", errMsg " + str);
        this.gJT.a(i, i2, str, this);
    }
}
