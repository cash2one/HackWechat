package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abg;
import com.tencent.mm.protocal.c.abh;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    public String country;
    public String fWp;
    public String fWq;
    private b gJQ;
    private e gJT;

    public n(double d, double d2) {
        a aVar = new a();
        aVar.hmj = new abg();
        aVar.hmk = new abh();
        aVar.uri = "/cgi-bin/micromsg-bin/getcurlocation";
        this.gJQ = aVar.JZ();
        abg com_tencent_mm_protocal_c_abg = (abg) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_abg.vNP = d;
        com_tencent_mm_protocal_c_abg.vNO = d2;
        x.d("MicroMsg.NetSceneGetCurLocation", "latitude:" + d + ", longitude:" + d2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 665;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            abh com_tencent_mm_protocal_c_abh = (abh) this.gJQ.hmh.hmo;
            this.fWq = com_tencent_mm_protocal_c_abh.hvv;
            this.country = com_tencent_mm_protocal_c_abh.hvC;
            this.fWp = com_tencent_mm_protocal_c_abh.hvu;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
