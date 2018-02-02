package com.tencent.mm.aw;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ayy;
import com.tencent.mm.protocal.c.ayz;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    boolean hHZ = false;
    int hIa = 0;

    public a(int i, int i2, String str) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new ayy();
        aVar.hmk = new ayz();
        aVar.uri = "/cgi-bin/micromsg-bin/pushnewtips";
        aVar.hmi = 597;
        this.gJQ = aVar.JZ();
        ayy com_tencent_mm_protocal_c_ayy = (ayy) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_ayy.wFX = i;
        com_tencent_mm_protocal_c_ayy.wFY = i2;
        com_tencent_mm_protocal_c_ayy.vNj = str;
        this.hIa = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            this.hHZ = ((ayz) ((b) qVar).hmh.hmo).wFZ;
            this.gJT.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetScenePushNewTips", "errType:" + i2 + " errCode:" + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 597;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetScenePushNewTips", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
