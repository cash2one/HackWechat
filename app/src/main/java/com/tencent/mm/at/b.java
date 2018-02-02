package com.tencent.mm.at;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bov;
import com.tencent.mm.protocal.c.bow;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ae.b gJQ;
    private e gJT;

    public b() {
        a aVar = new a();
        aVar.hmj = new bov();
        aVar.hmk = new bow();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindlinkedincontact";
        aVar.hmi = 550;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((bov) this.gJQ.hmg.hmo).vJL = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 550;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUnBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ar.Hg();
            c.CU().set(286722, "");
            ar.Hg();
            c.CU().set(286721, "");
            ar.Hg();
            c.CU().set(286723, "");
        }
        this.gJT.a(i2, i3, str, this);
    }
}
