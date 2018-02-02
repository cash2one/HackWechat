package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bax;
import com.tencent.mm.protocal.c.bbe;
import com.tencent.mm.protocal.c.bbf;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public h(com.tencent.mm.plugin.address.d.b bVar) {
        a aVar = new a();
        aVar.hmj = new bbe();
        aVar.hmk = new bbf();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
        aVar.hmi = 418;
        aVar.hml = 203;
        aVar.hmm = 1000000203;
        this.gJQ = aVar.JZ();
        bbe com_tencent_mm_protocal_c_bbe = (bbe) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bbe.wHt = new bax();
        com_tencent_mm_protocal_c_bbe.wHt.id = bVar.id;
        com_tencent_mm_protocal_c_bbe.wHt.wHA = new bdo().UA(bh.az(bVar.iml, ""));
        com_tencent_mm_protocal_c_bbe.wHt.wHy = new bdo().UA(bh.az(bVar.imj, ""));
        com_tencent_mm_protocal_c_bbe.wHt.wHD = new bdo().UA(bh.az(bVar.imo, ""));
        com_tencent_mm_protocal_c_bbe.wHt.wHB = new bdo().UA(bh.az(bVar.imm, ""));
        com_tencent_mm_protocal_c_bbe.wHt.wHE = new bdo().UA(bh.az(bVar.imp, ""));
        com_tencent_mm_protocal_c_bbe.wHt.wHF = new bdo().UA(bh.az(bVar.imq, ""));
        com_tencent_mm_protocal_c_bbe.wHt.wHz = new bdo().UA(bh.az(bVar.imk, ""));
        com_tencent_mm_protocal_c_bbe.wHt.wHC = new bdo().UA(bh.az(bVar.imn, ""));
        com_tencent_mm_protocal_c_bbe.wHt.wHG = new bdo().UA(bh.az(bVar.imr, ""));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoUpdate", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bbf com_tencent_mm_protocal_c_bbf = (bbf) ((b) qVar).hmh.hmo;
            if (com_tencent_mm_protocal_c_bbf.wHu.wHx != null) {
                x.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + com_tencent_mm_protocal_c_bbf.wHu.wHx.size());
                com.tencent.mm.plugin.address.a.a.XE();
                com.tencent.mm.plugin.address.a.a.XG().p(com_tencent_mm_protocal_c_bbf.wHu.wHx);
                com.tencent.mm.plugin.address.a.a.XE();
                com.tencent.mm.plugin.address.a.a.XG().XI();
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 418;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
