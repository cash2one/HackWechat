package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ayf;
import com.tencent.mm.protocal.c.ayg;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.b gJQ = null;
    private e gJT;
    private ayf nFq = null;
    public ayg nFr = null;

    public b(String str, String str2, String str3, String str4, int i) {
        a aVar = new a();
        aVar.hmj = new ayf();
        aVar.hmk = new ayg();
        aVar.hmi = 807;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.nFq = (ayf) this.gJQ.hmg.hmo;
        this.nFq.wFt = str;
        this.nFq.wFv = str2;
        this.nFq.wFx = str3;
        this.nFq.wFw = str4;
        this.nFq.wFy = i;
        x.i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", new Object[]{str, str2, str3, str4, Integer.valueOf(i)});
    }

    public final int getType() {
        return 807;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.nFr = (ayg) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
