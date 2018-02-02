package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.qk;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private String fGU = "";
    private final b gJQ;
    private e gJT;
    public int kLO;

    public a(String str) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new qj();
        aVar.hmk = new qk();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
        aVar.hmi = 1163;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((qj) this.gJQ.hmg.hmo).fGU = str;
        this.fGU = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(1163), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            qk qkVar = (qk) this.gJQ.hmh.hmo;
            x.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + qkVar.kLO);
            this.kLO = qkVar.kLO;
            if (this.kLO == 0) {
                am.auI().wu(this.fGU);
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1163;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
