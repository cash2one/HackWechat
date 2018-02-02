package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aiw;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.sdk.platformtools.x;

public final class af extends k implements com.tencent.mm.network.k {
    public String fGV;
    private final b gJQ;
    private e gJT;
    public int kLO;
    public String kLP;

    public af(String str, String str2, int i) {
        a aVar = new a();
        aVar.hmj = new aiw();
        aVar.hmk = new aix();
        aVar.uri = "/cgi-bin/micromsg-bin/giftcarditem";
        aVar.hmi = 652;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aiw com_tencent_mm_protocal_c_aiw = (aiw) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aiw.fGU = str;
        com_tencent_mm_protocal_c_aiw.wqt = str2;
        com_tencent_mm_protocal_c_aiw.wqu = i;
    }

    public final int getType() {
        return 652;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGiftCardItem", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        aix com_tencent_mm_protocal_c_aix;
        if (i2 == 0 && i3 == 0) {
            com_tencent_mm_protocal_c_aix = (aix) this.gJQ.hmh.hmo;
            if (com_tencent_mm_protocal_c_aix != null) {
                this.fGV = com_tencent_mm_protocal_c_aix.fGV;
                this.kLP = com_tencent_mm_protocal_c_aix.kLP;
                this.kLO = com_tencent_mm_protocal_c_aix.kLO;
            }
        } else {
            com_tencent_mm_protocal_c_aix = (aix) this.gJQ.hmh.hmo;
            if (com_tencent_mm_protocal_c_aix != null) {
                this.fGV = com_tencent_mm_protocal_c_aix.fGV;
                this.kLP = com_tencent_mm_protocal_c_aix.kLP;
                this.kLO = com_tencent_mm_protocal_c_aix.kLO;
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
