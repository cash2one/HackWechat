package com.tencent.mm.ab;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.gp;
import com.tencent.mm.protocal.c.gq;

public final class a extends k implements com.tencent.mm.network.k {
    public static int hjv = 1;
    public static int hjw = 2;
    private b gJQ;
    private e gJT;

    public a(int i, String str) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new gp();
        aVar.hmk = new gq();
        aVar.uri = "/cgi-bin/micromsg-bin/bindemail";
        aVar.hmi = 256;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        gp gpVar = (gp) this.gJQ.hmg.hmo;
        gpVar.vDW = i;
        gpVar.vLN = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 256;
    }

    public final int IS() {
        return ((gp) this.gJQ.hmg.hmo).vDW;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
