package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.kb;
import com.tencent.mm.protocal.c.kc;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public a(String str, String str2) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new kb();
        aVar.hmk = new kc();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
        aVar.hmi = 1252;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        kb kbVar = (kb) this.gJQ.hmg.hmo;
        kbVar.kJN = str;
        kbVar.fGV = str2;
    }

    public final int getType() {
        return 1252;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCancelShakeCard", "onGYNetEnd, getType = 1252" + " errType = " + i2 + " errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }
}
