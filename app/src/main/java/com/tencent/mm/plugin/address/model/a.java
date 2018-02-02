package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.qx;
import com.tencent.mm.protocal.c.qy;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public a(int i) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new qx();
        aVar.hmk = new qy();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
        aVar.hmi = 1194;
        this.gJQ = aVar.JZ();
        qx qxVar = (qx) this.gJQ.hmg.hmo;
        qxVar.vYY = "invoice_info";
        qxVar.vYZ = i;
        qxVar.cOY = 2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDeleteUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneDeleteUserAutoFillInfo", "");
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1194;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
