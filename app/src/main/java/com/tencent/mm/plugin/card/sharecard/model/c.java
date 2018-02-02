package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afz;
import com.tencent.mm.protocal.c.aga;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public String kLN;

    public c(String str) {
        a aVar = new a();
        aVar.hmj = new afz();
        aVar.hmk = new aga();
        aVar.uri = "/cgi-bin/micromsg-bin/getsharecard";
        aVar.hmi = 904;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((afz) this.gJQ.hmg.hmo).fGU = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(904), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            aga com_tencent_mm_protocal_c_aga = (aga) this.gJQ.hmh.hmo;
            x.v("MicroMsg.NetSceneGetShareCard", "json:" + com_tencent_mm_protocal_c_aga.kLN);
            this.kLN = com_tencent_mm_protocal_c_aga.kLN;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 904;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
