package com.tencent.mm.bb;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.qr;
import com.tencent.mm.protocal.c.qs;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public a(String str) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new qr();
        aVar.hmk = new qs();
        aVar.uri = "/cgi-bin/micromsg-bin/deletecardimg";
        aVar.hmi = 576;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((qr) this.gJQ.hmg.hmo).vYX = str;
    }

    public final int getType() {
        return 576;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDeleteCardImg", "onGYNetEnd:%s, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gJT.a(i2, i3, str, this);
    }
}
