package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aab;
import com.tencent.mm.protocal.c.aac;
import com.tencent.mm.sdk.platformtools.x;

public final class z extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public CardGiftInfo kLQ;

    public z(int i, String str) {
        a aVar = new a();
        aVar.hmj = new aab();
        aVar.hmk = new aac();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
        aVar.hmi = 1165;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aab com_tencent_mm_protocal_c_aab = (aab) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aab.vEM = i;
        com_tencent_mm_protocal_c_aab.vEN = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.kLQ = CardGiftInfo.a((aac) this.gJQ.hmh.hmo);
            x.d("MicroMsg.NetSceneGetCardGiftInfo", "%s", new Object[]{this.kLQ.toString()});
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1165;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
