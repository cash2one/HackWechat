package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbb;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public int ilU = 0;

    public f(int i) {
        a aVar = new a();
        aVar.hmj = new bba();
        aVar.hmk = new bbb();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
        aVar.hmi = 416;
        aVar.hml = 201;
        aVar.hmm = 1000000201;
        this.gJQ = aVar.JZ();
        this.ilU = i;
        x.d("MicroMsg.NetSceneRcptInfoRemove", "remove Id " + i);
        ((bba) this.gJQ.hmg.hmo).id = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoRemove", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bbb com_tencent_mm_protocal_c_bbb = (bbb) ((b) qVar).hmh.hmo;
            if (com_tencent_mm_protocal_c_bbb.wHu.wHx != null) {
                x.d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_bbb.wHu.wHx.size());
                com.tencent.mm.plugin.address.a.a.XE();
                com.tencent.mm.plugin.address.a.a.XG().p(com_tencent_mm_protocal_c_bbb.wHu.wHx);
                com.tencent.mm.plugin.address.a.a.XE();
                com.tencent.mm.plugin.address.a.a.XG().XI();
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 416;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
