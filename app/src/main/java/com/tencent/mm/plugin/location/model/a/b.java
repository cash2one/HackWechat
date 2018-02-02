package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amy;
import com.tencent.mm.protocal.c.amz;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public int errCode;
    public int errType;
    public String fnL;
    public final com.tencent.mm.ae.b gJQ;
    private e gJT;
    private Runnable hOe;
    public String jcO;
    public String nQv = "";

    public b(String str) {
        a aVar = new a();
        aVar.hmj = new amy();
        aVar.hmk = new amz();
        aVar.uri = "/cgi-bin/micromsg-bin/jointrackroom";
        aVar.hmi = 490;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((amy) this.gJQ.hmg.hmo).wum = str;
        x.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:" + str);
    }

    public final int getType() {
        return 490;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        amz com_tencent_mm_protocal_c_amz;
        this.errType = i2;
        this.errCode = i3;
        this.fnL = str;
        if (((com.tencent.mm.ae.b) qVar).hmh.hmo != null) {
            com_tencent_mm_protocal_c_amz = (amz) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
        } else {
            com_tencent_mm_protocal_c_amz = null;
        }
        x.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if ((i3 == 0 || i3 >= 1000) && com_tencent_mm_protocal_c_amz != null) {
            this.nQv = com_tencent_mm_protocal_c_amz.wbr;
            x.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", new Object[]{this.nQv});
        }
        if (com_tencent_mm_protocal_c_amz != null) {
            this.jcO = com_tencent_mm_protocal_c_amz.vQQ;
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
        if (this.hOe != null) {
            this.hOe.run();
        }
    }
}
