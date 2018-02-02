package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.protocal.c.apb;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public u() {
        a aVar = new a();
        aVar.hmj = new apa();
        aVar.hmk = new apb();
        aVar.uri = "/cgi-bin/micromsg-bin/logout";
        aVar.hmi = 282;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((apa) this.gJQ.hmg.hmo).rYW = 0;
    }

    public final int getType() {
        return 282;
    }

    public final String RW() {
        return ((apb) this.gJQ.hmh.hmo).wvQ;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneLogout", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            x.d("MicroMsg.NetSceneLogout", "logout Error. ");
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
