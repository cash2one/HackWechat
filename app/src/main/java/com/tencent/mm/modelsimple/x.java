package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azu;
import com.tencent.mm.protocal.c.azv;

public final class x extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public int hNL = 1;
    public int hNM;

    public x(int i) {
        a aVar = new a();
        aVar.hmj = new azu();
        aVar.hmk = new azv();
        aVar.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
        aVar.hmi = 255;
        aVar.hml = 132;
        aVar.hmm = 1000000132;
        this.gJQ = aVar.JZ();
        ((azu) this.gJQ.hmg.hmo).rYW = i;
        this.hNM = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 255;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
