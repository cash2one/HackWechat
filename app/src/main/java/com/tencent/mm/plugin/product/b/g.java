package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.add;
import com.tencent.mm.protocal.c.ade;
import com.tencent.mm.protocal.c.cb;
import com.tencent.mm.protocal.c.ti;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class g extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public LinkedList<ti> pdX;
    public String pef;

    public g(String str, String str2, cb cbVar) {
        a aVar = new a();
        aVar.hmj = new add();
        aVar.hmk = new ade();
        aVar.uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
        this.gJQ = aVar.JZ();
        add com_tencent_mm_protocal_c_add = (add) this.gJQ.hmg.hmo;
        this.pef = str;
        com_tencent_mm_protocal_c_add.vPA = str;
        x.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid " + str);
        com_tencent_mm_protocal_c_add.vQO = str2;
        com_tencent_mm_protocal_c_add.wlA = cbVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        ade com_tencent_mm_protocal_c_ade = (ade) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0 && com_tencent_mm_protocal_c_ade.vQP == 0) {
            x.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + com_tencent_mm_protocal_c_ade.wlC);
            this.pdX = com_tencent_mm_protocal_c_ade.wlB;
        }
        if (i3 == 0 && com_tencent_mm_protocal_c_ade.vQP != 0) {
            i3 = com_tencent_mm_protocal_c_ade.vQP;
            str = com_tencent_mm_protocal_c_ade.vQQ;
        }
        x.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + i3 + ", errMsg " + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 578;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
