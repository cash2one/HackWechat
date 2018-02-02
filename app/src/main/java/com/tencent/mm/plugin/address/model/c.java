package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bas;
import com.tencent.mm.protocal.c.bat;
import com.tencent.mm.protocal.c.bax;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public c(com.tencent.mm.plugin.address.d.b bVar) {
        a aVar = new a();
        aVar.hmj = new bas();
        aVar.hmk = new bat();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
        aVar.hmi = 415;
        aVar.hml = 200;
        aVar.hmm = 1000000200;
        this.gJQ = aVar.JZ();
        bas com_tencent_mm_protocal_c_bas = (bas) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bas.wHt = new bax();
        com_tencent_mm_protocal_c_bas.wHt.wHA = new bdo().UA(bh.az(bVar.iml, ""));
        com_tencent_mm_protocal_c_bas.wHt.wHy = new bdo().UA(bh.az(bVar.imj, ""));
        com_tencent_mm_protocal_c_bas.wHt.wHD = new bdo().UA(bh.az(bVar.imo, ""));
        com_tencent_mm_protocal_c_bas.wHt.wHB = new bdo().UA(bh.az(bVar.imm, ""));
        com_tencent_mm_protocal_c_bas.wHt.wHE = new bdo().UA(bh.az(bVar.imp, ""));
        com_tencent_mm_protocal_c_bas.wHt.wHF = new bdo().UA(bh.az(bVar.imq, ""));
        com_tencent_mm_protocal_c_bas.wHt.wHz = new bdo().UA(bh.az(bVar.imk, ""));
        com_tencent_mm_protocal_c_bas.wHt.wHC = new bdo().UA(bh.az(bVar.imn, ""));
        com_tencent_mm_protocal_c_bas.wHt.wHG = new bdo().UA(bh.az(bVar.imr, ""));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bat com_tencent_mm_protocal_c_bat = (bat) ((b) qVar).hmh.hmo;
            if (com_tencent_mm_protocal_c_bat.wHu.wHx != null) {
                x.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_bat.wHu.wHx.size());
                com.tencent.mm.plugin.address.a.a.XE();
                com.tencent.mm.plugin.address.a.a.XG().p(com_tencent_mm_protocal_c_bat.wHu.wHx);
                com.tencent.mm.plugin.address.a.a.XE();
                com.tencent.mm.plugin.address.a.a.XG().XI();
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 415;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
