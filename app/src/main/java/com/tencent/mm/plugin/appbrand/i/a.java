package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bxn;
import com.tencent.mm.protocal.c.bxo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import java.util.Locale;

public final class a extends k implements com.tencent.mm.network.k {
    private e gOB;
    private b hjD;
    private bxo jBc;

    public a() {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new bxn();
        aVar.hmk = new bxo();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearchtitle";
        aVar.hmi = 1170;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hjD = aVar.JZ();
    }

    public final int getType() {
        return 1170;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetWeAppSearchTitle", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.hjD, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetWeAppSearchTitle", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.jBc = (bxo) this.hjD.hmh.hmo;
        if (this.gOB != null) {
            this.gOB.a(i2, i3, str, this);
        }
        if (this.jBc.wYp != null) {
            t CU = g.Dj().CU();
            CU.a(com.tencent.mm.storage.w.a.xtE, Locale.getDefault().getLanguage());
            CU.a(com.tencent.mm.storage.w.a.xtF, this.jBc.wYp.nGK);
            CU.a(com.tencent.mm.storage.w.a.xtG, this.jBc.wYp.wYo);
            CU.a(com.tencent.mm.storage.w.a.xtH, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
