package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.am;
import com.tencent.mm.protocal.c.an;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public CardGiftInfo kLQ;

    public q(int i, String str, String str2, Boolean bool) {
        a aVar = new a();
        aVar.hmj = new am();
        aVar.hmk = new an();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptgiftcard";
        aVar.hmi = 1136;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        am amVar = (am) this.gJQ.hmg.hmo;
        amVar.vEM = i;
        amVar.vEN = str;
        amVar.vEO = str2;
        amVar.vEP = bool.booleanValue();
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.kLQ = CardGiftInfo.a((an) this.gJQ.hmh.hmo);
            x.d("MicroMsg.NetSceneAcceptGiftCard", "%s", new Object[]{this.kLQ.toString()});
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1136;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
