package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.protocal.c.bbc;
import com.tencent.mm.protocal.c.bbd;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public g(int i) {
        a aVar = new a();
        aVar.hmj = new bbc();
        aVar.hmk = new bbd();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfotouch";
        aVar.hmi = 419;
        aVar.hml = d.CTRL_INDEX;
        aVar.hmm = 1000000204;
        this.gJQ = aVar.JZ();
        ((bbc) this.gJQ.hmg.hmo).id = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoTouch", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bbd com_tencent_mm_protocal_c_bbd = (bbd) ((b) qVar).hmh.hmo;
            if (com_tencent_mm_protocal_c_bbd.wHu.wHx != null) {
                x.d("MicroMsg.NetSceneRcptInfoTouch", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_bbd.wHu.wHx.size());
                com.tencent.mm.plugin.address.a.a.XE();
                com.tencent.mm.plugin.address.a.a.XG().p(com_tencent_mm_protocal_c_bbd.wHu.wHx);
                com.tencent.mm.plugin.address.a.a.XE();
                com.tencent.mm.plugin.address.a.a.XG().XI();
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 419;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
