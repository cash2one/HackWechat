package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.aly;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gOB;

    public k(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new alx();
        aVar.hmk = new aly();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetuseropenid";
        aVar.hmi = 1566;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        alx com_tencent_mm_protocal_c_alx = (alx) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_alx.ksU = str2;
        com_tencent_mm_protocal_c_alx.ngo = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1566;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetUserOpenId", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
