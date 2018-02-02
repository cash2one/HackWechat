package com.tencent.mm.at;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.gv;
import com.tencent.mm.protocal.c.gw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public a(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new gv();
        aVar.hmk = new gw();
        aVar.uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
        aVar.hmi = 549;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        gv gvVar = (gv) this.gJQ.hmg.hmo;
        gvVar.vJL = 1;
        gvVar.vLT = i;
        gvVar.vLU = str;
        gvVar.vLV = str2;
        gvVar.vLW = str3;
        gvVar.vLX = str4;
        gvVar.vLY = str5;
        gvVar.vLZ = str6;
        gvVar.vMa = str7;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 549;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        gv gvVar = (gv) this.gJQ.hmg.hmo;
        if (i2 == 0 && i3 == 0) {
            ar.Hg();
            c.CU().set(286722, gvVar.vLV);
            ar.Hg();
            c.CU().set(286721, gvVar.vLU);
            ar.Hg();
            c.CU().set(286723, gvVar.vLW);
        }
        this.gJT.a(i2, i3, str, this);
    }
}
