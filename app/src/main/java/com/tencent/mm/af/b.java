package com.tencent.mm.af;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.box;
import com.tencent.mm.protocal.c.boy;

public final class b extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.b gJQ;
    private e gJT;

    public b(String str) {
        a aVar = new a();
        aVar.hmj = new box();
        aVar.hmk = new boy();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindqq";
        aVar.hmi = 253;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((box) this.gJQ.hmg.hmo).vZK = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 253;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
