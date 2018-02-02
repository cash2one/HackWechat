package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.g;
import com.tencent.mm.protocal.c.btt;
import com.tencent.mm.protocal.c.btu;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;

    public d(long j, long j2) {
        a aVar = new a();
        aVar.hmj = new btt();
        aVar.hmk = new btu();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipredirect";
        aVar.hmi = g.CTRL_INDEX;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        btt com_tencent_mm_protocal_c_btt = (btt) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_btt.wUT = j;
        com_tencent_mm_protocal_c_btt.wbi = j2;
        com_tencent_mm_protocal_c_btt.wFp = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSRedirect", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return g.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
