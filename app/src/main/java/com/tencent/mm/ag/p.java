package com.tencent.mm.ag;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hg;
import com.tencent.mm.protocal.c.hh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class p extends k implements com.tencent.mm.network.k {
    private String gAb;
    b gJQ;
    private e gJT;
    private a<p> hqe;

    public p(String str, String str2, a<p> aVar) {
        this(str, str2);
        this.hqe = aVar;
    }

    private p(String str, String str2) {
        this.gAb = str;
        x.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] NetSceneBizAttrSync (%s)", new Object[]{str});
        a aVar = new a();
        aVar.hmi = 1075;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/bizattrsync";
        aVar.hmj = new hg();
        aVar.hmk = new hh();
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        hg hgVar = (hg) this.gJQ.hmg.hmo;
        hgVar.vNg = this.gAb;
        hgVar.vNh = new com.tencent.mm.bq.b(bh.VD(bh.ou(str2)));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBizAttrSync", "[BizAttr] onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
        if (this.hqe != null) {
            this.hqe.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1075;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
