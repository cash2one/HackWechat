package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.cq;
import com.tencent.mm.protocal.c.cr;

public final class x extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    int veD;
    w veE;

    public x(int i, w wVar) {
        this.veD = i;
        a aVar = new a();
        aVar.hmj = new cq();
        aVar.hmk = new cr();
        aVar.uri = "/cgi-bin/micromsg-bin/appcenter";
        aVar.hmi = 452;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        cq cqVar = (cq) this.gJQ.hmg.hmo;
        byte[] aQX = wVar.aQX();
        if (aQX != null) {
            cqVar.vHG = new bdn().bj(aQX);
        }
        cqVar.ktN = i;
        this.veE = wVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            this.veE.ax(n.a(((cr) this.gJQ.hmh.hmo).vHH));
            this.veE.a(i, i2, i3, str, this.gJQ, bArr);
            this.gJT.a(i2, i3, str, this);
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 452;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
