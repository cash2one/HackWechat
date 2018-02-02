package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ai;
import com.tencent.mm.protocal.c.aj;
import com.tencent.mm.protocal.c.blp;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public String kLN;
    public int kLO;
    public String kLP;

    public o(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, blp com_tencent_mm_protocal_c_blp) {
        a aVar = new a();
        aVar.hmj = new ai();
        aVar.hmk = new aj();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcarditem";
        this.gJQ = aVar.JZ();
        ai aiVar = (ai) this.gJQ.hmg.hmo;
        aiVar.fGU = str;
        aiVar.kKY = str2;
        aiVar.fGW = i;
        aiVar.fGV = str3;
        aiVar.vEH = str4;
        aiVar.vEG = str5;
        aiVar.vEI = i2;
        aiVar.vEJ = i3;
        aiVar.vEK = com_tencent_mm_protocal_c_blp;
    }

    public final int getType() {
        return 651;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        aj ajVar;
        if (i2 == 0 && i3 == 0) {
            ajVar = (aj) this.gJQ.hmh.hmo;
            if (ajVar != null) {
                this.kLN = ajVar.kLN;
                this.kLO = ajVar.kLO;
                this.kLP = ajVar.kLP;
            }
        } else {
            ajVar = (aj) this.gJQ.hmh.hmo;
            if (ajVar != null) {
                this.kLN = ajVar.kLN;
                this.kLO = ajVar.kLO;
                this.kLP = ajVar.kLP;
            }
        }
        this.gJT.a(i2, i3, str, this);
    }
}
