package com.tencent.mm.plugin.nfc_open.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.pg;
import com.tencent.mm.protocal.c.ph;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public com.tencent.mm.ae.b gJQ;
    private e gJT;

    public b(int i) {
        a aVar = new a();
        aVar.hmj = new pg();
        aVar.hmk = new ph();
        aVar.uri = "/cgi-bin/mmpay-bin/cpucardgetconfig2";
        aVar.hmi = 1561;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((pg) this.gJQ.hmg.hmo).version = i;
    }

    public final int getType() {
        return 1561;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCpuCardGetConfig", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gJT.a(i2, i3, str, this);
    }
}
