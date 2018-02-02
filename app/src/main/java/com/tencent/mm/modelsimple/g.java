package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ud;
import com.tencent.mm.protocal.c.ue;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class g extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public int opType;

    public g(int i, String str) {
        this.opType = i;
        a aVar = new a();
        aVar.hmj = new ud();
        aVar.hmk = new ue();
        aVar.uri = "/cgi-bin/micromsg-bin/facebookauth";
        aVar.hmi = 183;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ud udVar = (ud) this.gJQ.hmg.hmo;
        if (bh.ov(str)) {
            str = "";
        }
        udVar.wcb = str;
        udVar.nhx = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 183;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ue ueVar = (ue) this.gJQ.hmh.hmo;
            int i4 = ueVar.wJr.vJU;
            if (i4 != 0) {
                x.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = " + i4);
                this.gJT.a(4, i4, str, this);
                return;
            }
            x.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + ueVar.wcd + ", fbusername = " + ueVar.wce);
            if (this.opType == 0 || this.opType == 1) {
                ar.Hg();
                c.CU().set(65825, ueVar.wcd);
                com.tencent.mm.ad.b.iQ(ueVar.wcd);
                ar.Hg();
                c.CU().set(65826, ueVar.wce);
                ar.Hg();
                c.CU().lH(true);
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
