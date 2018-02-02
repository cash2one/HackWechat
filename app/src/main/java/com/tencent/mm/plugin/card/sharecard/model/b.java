package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aaj;
import com.tencent.mm.protocal.c.aak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class b extends k implements com.tencent.mm.network.k {
    private final com.tencent.mm.ae.b gJQ;
    private e gJT;
    public String kLN;
    public String kNf = "";

    public b(double d, double d2, String str) {
        a aVar = new a();
        aVar.hmj = new aaj();
        aVar.hmk = new aak();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
        aVar.hmi = 1164;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aaj com_tencent_mm_protocal_c_aaj = (aaj) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aaj.latitude = d;
        com_tencent_mm_protocal_c_aaj.longitude = d2;
        com_tencent_mm_protocal_c_aaj.kNf = str;
        ar.Hg();
        com_tencent_mm_protocal_c_aaj.wjv = (String) c.CU().get(w.a.xok, "");
        x.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + com_tencent_mm_protocal_c_aaj.wjv);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(1164), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            aak com_tencent_mm_protocal_c_aak = (aak) this.gJQ.hmh.hmo;
            x.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + com_tencent_mm_protocal_c_aak.kLN);
            this.kLN = com_tencent_mm_protocal_c_aak.kLN;
            this.kNf = com_tencent_mm_protocal_c_aak.kNf;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1164;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
