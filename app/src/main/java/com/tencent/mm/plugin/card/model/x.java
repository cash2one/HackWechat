package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zx;
import com.tencent.mm.protocal.c.zy;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class x extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    private String kLY = "";

    public x() {
        a aVar = new a();
        aVar.hmj = new zx();
        aVar.hmk = new zy();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardconfiginfo";
        aVar.hmi = 692;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 692;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneGetCardConfigInfo", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            this.kLY = ((zy) this.gJQ.hmh.hmo).kLN;
            ar.Hg();
            c.CU().set(282885, this.kLY);
        }
        this.gJT.a(i2, i3, str, this);
    }
}
