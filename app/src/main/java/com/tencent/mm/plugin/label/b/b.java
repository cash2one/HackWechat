package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ae.b gJQ;
    private e gJT;
    public String nOE = null;

    public b(String str) {
        a aVar = new a();
        aVar.hmj = new py();
        aVar.hmk = new pz();
        aVar.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
        aVar.hmi = 636;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.nOE = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 636;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        py pyVar = (py) this.gJQ.hmg.hmo;
        pyVar.vYL = this.nOE;
        if (this.nOE == null || bh.ov(this.nOE)) {
            x.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
            eVar2.a(3, -1, "[doScene]empty label is list.", this);
            return 0;
        }
        pyVar.vYL = this.nOE;
        pyVar.vYL = this.nOE;
        return a(eVar, this.gJQ, this);
    }
}
