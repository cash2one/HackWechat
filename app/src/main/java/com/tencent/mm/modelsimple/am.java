package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apc;
import com.tencent.mm.protocal.c.apd;
import com.tencent.mm.sdk.platformtools.x;

public final class am extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public am(int i) {
        a aVar = new a();
        aVar.hmj = new apc();
        aVar.hmk = new apd();
        aVar.uri = "/cgi-bin/micromsg-bin/logoutwebwx";
        aVar.hmi = 281;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((apc) this.gJQ.hmg.hmo).vDW = i;
    }

    public final int getType() {
        return 281;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneWebWXLogout", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            x.d("MicroMsg.NetSceneWebWXLogout", "logout Error. ");
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
