package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bgj;
import com.tencent.mm.protocal.c.bgk;

public final class af extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public af(String str) {
        a aVar = new a();
        aVar.hmj = new bgj();
        aVar.hmk = new bgk();
        aVar.uri = "/cgi-bin/micromsg-bin/sendverifyemail";
        aVar.hmi = 108;
        aVar.hml = 43;
        aVar.hmm = 1000000043;
        this.gJQ = aVar.JZ();
        ((bgj) this.gJQ.hmg.hmo).vYI = new bdo().UA(str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 108;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
