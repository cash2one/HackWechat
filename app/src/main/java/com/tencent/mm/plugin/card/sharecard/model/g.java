package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.protocal.c.bii;
import com.tencent.mm.protocal.c.blp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class g extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public String kLN;
    public int kLO;
    public String kLP;

    public g(int i, LinkedList<bia> linkedList, String str, String str2, bii com_tencent_mm_protocal_c_bii, int i2, blp com_tencent_mm_protocal_c_blp) {
        a aVar = new a();
        aVar.hmj = new bhy();
        aVar.hmk = new bhz();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecarditem";
        aVar.hmi = 902;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bhy com_tencent_mm_protocal_c_bhy = (bhy) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bhy.wLA = i;
        com_tencent_mm_protocal_c_bhy.hdX = linkedList;
        com_tencent_mm_protocal_c_bhy.wLB = str;
        com_tencent_mm_protocal_c_bhy.wjt = str2;
        x.i("MicroMsg.NetSceneShareCardItem", "list length is " + linkedList.size());
        com_tencent_mm_protocal_c_bhy.wLC = com_tencent_mm_protocal_c_bii;
        com_tencent_mm_protocal_c_bhy.fGW = i2;
        com_tencent_mm_protocal_c_bhy.vEK = com_tencent_mm_protocal_c_blp;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneShareCardItem", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(902), Integer.valueOf(i2), Integer.valueOf(i3)});
        bhz com_tencent_mm_protocal_c_bhz;
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneShareCardItem", "do ShareCardItem netscene success!");
            com_tencent_mm_protocal_c_bhz = (bhz) this.gJQ.hmh.hmo;
            if (com_tencent_mm_protocal_c_bhz != null) {
                this.kLN = com_tencent_mm_protocal_c_bhz.kLN;
                this.kLO = com_tencent_mm_protocal_c_bhz.kLO;
                this.kLP = com_tencent_mm_protocal_c_bhz.kLP;
            }
        } else {
            com_tencent_mm_protocal_c_bhz = (bhz) this.gJQ.hmh.hmo;
            if (com_tencent_mm_protocal_c_bhz != null) {
                this.kLN = com_tencent_mm_protocal_c_bhz.kLN;
                this.kLO = com_tencent_mm_protocal_c_bhz.kLO;
                this.kLP = com_tencent_mm_protocal_c_bhz.kLP;
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 902;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
