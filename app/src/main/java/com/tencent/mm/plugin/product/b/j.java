package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.axu;
import com.tencent.mm.protocal.c.axv;
import com.tencent.mm.protocal.c.bds;
import com.tencent.mm.protocal.c.ti;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public String pdM;
    public LinkedList<ti> pdX;
    public LinkedList<as> pdY;

    public j(LinkedList<bds> linkedList, int i) {
        int i2 = 0;
        a aVar = new a();
        aVar.hmj = new axu();
        aVar.hmk = new axv();
        aVar.uri = "/cgi-bin/micromsg-bin/presubmitorder";
        this.gJQ = aVar.JZ();
        axu com_tencent_mm_protocal_c_axu = (axu) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_axu.vQN = linkedList;
        if (linkedList != null) {
            i2 = linkedList.size();
        }
        com_tencent_mm_protocal_c_axu.pbw = i2;
        com_tencent_mm_protocal_c_axu.wES = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        axv com_tencent_mm_protocal_c_axv = (axv) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0 && com_tencent_mm_protocal_c_axv.vQP == 0) {
            x.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.ExpressCount " + com_tencent_mm_protocal_c_axv.wlC);
            x.d("MicroMsg.NetSceneMallPreSubmitOrder", "resp.LockId " + com_tencent_mm_protocal_c_axv.vQO);
            this.pdX = com_tencent_mm_protocal_c_axv.wET;
            this.pdM = com_tencent_mm_protocal_c_axv.vQO;
            this.pdY = com_tencent_mm_protocal_c_axv.wEU;
        }
        if (i3 == 0 && com_tencent_mm_protocal_c_axv.vQP != 0) {
            i3 = com_tencent_mm_protocal_c_axv.vQP;
            str = com_tencent_mm_protocal_c_axv.vQQ;
        }
        x.d("MicroMsg.NetSceneMallPreSubmitOrder", "errCode " + i3 + ", errMsg " + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 554;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
