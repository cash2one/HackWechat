package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.protocal.c.fe;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    private axz hNK;

    public w(int i) {
        a aVar = new a();
        aVar.hmj = new axz();
        aVar.hmk = new fe();
        aVar.hmi = 268;
        aVar.hml = 0;
        aVar.hmm = 0;
        aVar.uri = "/cgi-bin/micromsg-bin/privacypolicychoise";
        this.hNJ = aVar.JZ();
        this.hNK = (axz) this.hNJ.hmg.hmo;
        this.hNK.wFd = i;
    }

    public final int getType() {
        return 268;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetScenePrivacyPolicyChoice", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
