package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.qh;
import com.tencent.mm.protocal.c.qi;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class a extends k implements com.tencent.mm.network.k {
    private String ffq;
    private b gJQ;
    private e gJT;

    public a(String str) {
        this.ffq = str;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new qh();
        aVar.hmk = new qi();
        aVar.uri = "/cgi-bin/micromsg-bin/delsafedevice";
        aVar.hmi = 362;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((qh) this.gJQ.hmg.hmo).vYQ = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, errType= " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            qi qiVar = (qi) this.gJQ.hmh.hmo;
            ar.Hg();
            c.CU().set(64, Integer.valueOf(qiVar.vFx));
            x.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, get safedevice state = " + qiVar.vFx);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 362;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bh.ov(this.ffq)) {
            x.e("MicroMsg.NetSceneDelSafeDevice", "null device id");
            return -1;
        }
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
