package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.biu;
import com.tencent.mm.protocal.c.bmj;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public String pej;

    public k(biu com_tencent_mm_protocal_c_biu) {
        a aVar = new a();
        aVar.hmj = new bmj();
        aVar.hmk = new bmk();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallfreeorder";
        aVar.hmi = 557;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((bmj) this.gJQ.hmg.hmo).wPP = com_tencent_mm_protocal_c_biu;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bmk com_tencent_mm_protocal_c_bmk = (bmk) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "resp.PrepareId " + com_tencent_mm_protocal_c_bmk.wPQ);
            this.pej = com_tencent_mm_protocal_c_bmk.wPQ;
        }
        x.d("MicroMsg.NetSceneMallSubmitMallFreeOrder", "errCode " + i3 + ", errMsg " + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 557;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
