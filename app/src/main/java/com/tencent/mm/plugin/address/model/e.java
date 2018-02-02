package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bay;
import com.tencent.mm.protocal.c.baz;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    public String fpL;
    private b gJQ;
    private com.tencent.mm.ae.e gJT;
    public boolean ilT;
    public String username;

    public e(String str, String str2, int i) {
        a aVar = new a();
        aVar.hmj = new bay();
        aVar.hmk = new baz();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
        aVar.hmi = 417;
        aVar.hml = 202;
        aVar.hmm = 1000000202;
        this.gJQ = aVar.JZ();
        bay com_tencent_mm_protocal_c_bay = (bay) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bay.cRJ = 0;
        com_tencent_mm_protocal_c_bay.wHH = str;
        com_tencent_mm_protocal_c_bay.fFm = str2;
        com_tencent_mm_protocal_c_bay.scene = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        boolean z = true;
        x.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            baz com_tencent_mm_protocal_c_baz = (baz) ((b) qVar).hmh.hmo;
            this.username = com_tencent_mm_protocal_c_baz.lWn;
            this.fpL = com_tencent_mm_protocal_c_baz.wHK;
            if (com_tencent_mm_protocal_c_baz.wHJ != 1) {
                z = false;
            }
            this.ilT = z;
            if (com_tencent_mm_protocal_c_baz.wHu.wHx != null) {
                x.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_baz.wHu.wHx.size());
                com.tencent.mm.plugin.address.a.a.XE();
                com.tencent.mm.plugin.address.a.a.XG().p(com_tencent_mm_protocal_c_baz.wHu.wHx);
                com.tencent.mm.plugin.address.a.a.XE();
                com.tencent.mm.plugin.address.a.a.XG().XI();
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 417;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
