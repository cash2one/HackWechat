package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhd;
import com.tencent.mm.protocal.c.bhe;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class ag extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public ag(String str) {
        a aVar = new a();
        aVar.hmj = new bhd();
        aVar.hmk = new bhe();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetemailpwd";
        aVar.hmi = 382;
        aVar.hml = 181;
        aVar.hmm = 1000000181;
        this.gJQ = aVar.JZ();
        ((bhd) this.gJQ.hmg.hmo).vMp = bh.VB(str);
        x.d("MicroMsg.NetSceneSetEmailPwd", "md5 " + str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 382;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSetEmailPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gJT.a(i2, i3, str, this);
    }
}
