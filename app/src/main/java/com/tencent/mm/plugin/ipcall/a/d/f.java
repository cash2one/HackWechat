package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aia;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT;
    public boolean nFA = true;
    private aia nFy = null;
    public aib nFz = null;

    public f(String str, String str2) {
        if (bh.ov(str2)) {
            this.nFA = true;
            str2 = "";
        } else {
            this.nFA = false;
        }
        a aVar = new a();
        aVar.hmj = new aia();
        aVar.hmk = new aib();
        aVar.hmi = 929;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.nFy = (aia) this.gJQ.hmg.hmo;
        this.nFy.wpi = str;
        this.nFy.wpj = str2;
        x.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
    }

    public final int getType() {
        return 929;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nFz = (aib) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
