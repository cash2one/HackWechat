package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aes;
import com.tencent.mm.protocal.c.aet;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class h extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public String pef;
    public m peg;
    public List<n> peh;

    public h(m mVar, String str) {
        a aVar = new a();
        aVar.hmj = new aes();
        aVar.hmk = new aet();
        aVar.uri = "/cgi-bin/micromsg-bin/getproductdetail";
        this.gJQ = aVar.JZ();
        aes com_tencent_mm_protocal_c_aes = (aes) this.gJQ.hmg.hmo;
        this.pef = str;
        com_tencent_mm_protocal_c_aes.wmH = str;
        x.d("MicroMsg.NetSceneMallGetProductDetail", "pid " + str);
        com_tencent_mm_protocal_c_aes.ktM = 0;
        this.peg = mVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        aet com_tencent_mm_protocal_c_aet = (aet) ((b) qVar).hmh.hmo;
        if (!bh.ov(com_tencent_mm_protocal_c_aet.wmJ)) {
            x.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + com_tencent_mm_protocal_c_aet.wmJ);
            this.peg = m.a(this.peg, com_tencent_mm_protocal_c_aet.wmJ);
        }
        if (i3 == 0 && com_tencent_mm_protocal_c_aet.vQP != 0) {
            i3 = com_tencent_mm_protocal_c_aet.vQP;
            str = com_tencent_mm_protocal_c_aet.vQQ;
        }
        if (!bh.ov(com_tencent_mm_protocal_c_aet.wmK)) {
            x.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + com_tencent_mm_protocal_c_aet.wmK);
            this.peh = n.parse(com_tencent_mm_protocal_c_aet.wmK);
        }
        x.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + i3 + ", errMsg " + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 553;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
