package com.tencent.mm.modelstat;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acc;
import com.tencent.mm.protocal.c.acd;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private e gOB;
    final b hRB;

    public j(com.tencent.mm.bq.b bVar) {
        a aVar = new a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_acc = new acc();
        com_tencent_mm_protocal_c_acc.wkW = bVar;
        aVar.hmj = com_tencent_mm_protocal_c_acc;
        aVar.hmk = new acd();
        aVar.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
        aVar.hmi = 1126;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hRB = aVar.JZ();
    }

    public final int getType() {
        return 1126;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
        this.hmF = true;
        this.gOB = eVar2;
        return a(eVar, this.hRB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, qVar.toString()});
        this.gOB.a(i2, i3, str, this);
    }
}
