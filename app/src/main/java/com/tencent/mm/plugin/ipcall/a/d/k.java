package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aym;
import com.tencent.mm.protocal.c.ayn;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT = null;
    public aym nFJ = null;
    public ayn nFK = null;

    public k(int i, long j, long j2) {
        a aVar = new a();
        aVar.hmj = new aym();
        aVar.hmk = new ayn();
        aVar.hmi = 726;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnredirect";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.nFJ = (aym) this.gJQ.hmg.hmo;
        this.nFJ.wbh = i;
        this.nFJ.wbi = j;
        this.nFJ.wFs = j2;
    }

    public final int getType() {
        return 726;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nFK = (ayn) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
