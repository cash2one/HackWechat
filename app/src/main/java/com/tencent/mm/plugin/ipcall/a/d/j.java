package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bwr;
import com.tencent.mm.protocal.c.bws;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT = null;
    public bwr nFH = null;
    public bws nFI = null;

    public j(String str) {
        a aVar = new a();
        aVar.hmj = new bwr();
        aVar.hmk = new bws();
        aVar.hmi = 277;
        aVar.uri = "/cgi-bin/micromsg-bin/wcopurchasepackage";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.nFH = (bwr) this.gJQ.hmg.hmo;
        this.nFH.vIR = str;
        x.i("MicroMsg.NetSceneIPCallPurchasePackage", "NetSceneIPCallPurchasePackage ProductID:%s", new Object[]{this.nFH.vIR});
    }

    public final int getType() {
        return 277;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallPurchasePackage", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.nFI = (bws) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
