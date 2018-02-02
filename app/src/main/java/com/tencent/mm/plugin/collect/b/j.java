package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.kv;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    public kw liE;

    public j() {
        a aVar = new a();
        aVar.hmj = new kv();
        aVar.hmk = new kw();
        aVar.hmi = 1256;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fannounce";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        x.d("MicroMsg.NetSceneF2fAnnouce", "do cgi");
    }

    public final int getType() {
        return 1256;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneF2fAnnouce", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.liE = (kw) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
