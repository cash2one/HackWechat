package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afj;
import com.tencent.mm.protocal.c.afk;

public final class s extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b hFi;

    public s() {
        a aVar = new a();
        aVar.hmj = new afj();
        aVar.hmk = new afk();
        aVar.uri = "/cgi-bin/micromsg-bin/getremind";
        aVar.hmi = 866;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hFi = aVar.JZ();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final int getType() {
        return 866;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
