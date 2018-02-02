package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ak;
import com.tencent.mm.protocal.c.al;
import com.tencent.mm.protocal.c.kh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class p extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public String kLN;
    public int kLO;
    public String kLP;

    public p(LinkedList<kh> linkedList, int i, String str, String str2, int i2) {
        a aVar = new a();
        aVar.hmj = new ak();
        aVar.hmk = new al();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
        aVar.hmi = 687;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ak akVar = (ak) this.gJQ.hmg.hmo;
        akVar.vEL = linkedList;
        akVar.fGW = i;
        akVar.vEH = str;
        akVar.vEG = str2;
        akVar.vEI = i2;
    }

    public final int getType() {
        return 687;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            al alVar = (al) this.gJQ.hmh.hmo;
            this.kLN = alVar.kLN;
            this.kLO = alVar.kLO;
            this.kLP = alVar.kLP;
            x.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.kLO + " ret_msg = " + this.kLP);
        }
        this.gJT.a(i2, i3, str, this);
    }
}
