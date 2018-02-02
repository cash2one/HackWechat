package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bcl;
import com.tencent.mm.protocal.c.bcm;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public u(float f, float f2, String str, String str2, int i) {
        a aVar = new a();
        aVar.hmj = new bcl();
        aVar.hmk = new bcm();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
        aVar.hmi = 1253;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bcl com_tencent_mm_protocal_c_bcl = (bcl) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bcl.latitude = (double) f;
        com_tencent_mm_protocal_c_bcl.longitude = (double) f2;
        com_tencent_mm_protocal_c_bcl.fGU = str;
        com_tencent_mm_protocal_c_bcl.kJN = str2;
        com_tencent_mm_protocal_c_bcl.wIC = i;
    }

    public final int getType() {
        return 1253;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }
}
