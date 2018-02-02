package com.tencent.mm.plugin.address.model;

import com.tencent.mm.a.o;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.bav;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public int status;

    public d(String str, String str2, o oVar) {
        boolean z = true;
        a aVar = new a();
        aVar.hmj = new bau();
        aVar.hmk = new bav();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
        aVar.hmi = 582;
        aVar.hml = 0;
        aVar.hmm = 0;
        String str3 = "MicroMsg.NetSceneRcptInfoImportYiXun";
        StringBuilder append = new StringBuilder("a2key is ").append(!bh.ov(str)).append(", newa2key is ");
        if (bh.ov(str2)) {
            z = false;
        }
        x.d(str3, append.append(z).toString());
        this.gJQ = aVar.JZ();
        bau com_tencent_mm_protocal_c_bau = (bau) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bau.vJi = new bdn().bj(bh.VD(str));
        com_tencent_mm_protocal_c_bau.wHv = new bdn().bj(bh.VD(str2));
        com_tencent_mm_protocal_c_bau.cEm = oVar.intValue();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bav com_tencent_mm_protocal_c_bav = (bav) ((b) qVar).hmh.hmo;
            this.status = com_tencent_mm_protocal_c_bav.wHw;
            x.d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
            if (com_tencent_mm_protocal_c_bav.wHu.wHx != null && this.status == 0) {
                x.d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_bav.wHu.wHx.size());
                com.tencent.mm.plugin.address.a.a.XE();
                com.tencent.mm.plugin.address.a.a.XG().p(com_tencent_mm_protocal_c_bav.wHu.wHx);
                com.tencent.mm.plugin.address.a.a.XE();
                com.tencent.mm.plugin.address.a.a.XG().XI();
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 582;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
