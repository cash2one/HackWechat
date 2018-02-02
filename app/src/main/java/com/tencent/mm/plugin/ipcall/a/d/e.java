package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahy;
import com.tencent.mm.protocal.c.ahz;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private com.tencent.mm.ae.e gJT = null;
    private ahy nFw = null;
    public ahz nFx = null;

    public e() {
        a aVar = new a();
        aVar.hmj = new ahy();
        aVar.hmk = new ahz();
        aVar.hmi = 831;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcopackageproductlist";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.nFw = (ahy) this.gJQ.hmg.hmo;
        x.i("MicroMsg.NetSceneIPCallGetPackageProductList", "NetSceneIPCallGetPackageProductList");
    }

    public final int getType() {
        return 831;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallGetPackageProductList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nFx = (ahz) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
