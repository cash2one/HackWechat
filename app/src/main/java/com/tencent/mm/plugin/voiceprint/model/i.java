package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmt;
import com.tencent.mm.protocal.c.bmu;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public int mStatus;
    public int sgS;

    public i(int i) {
        a aVar = new a();
        aVar.hmj = new bmt();
        aVar.hmk = new bmu();
        aVar.uri = "/cgi-bin/micromsg-bin/switchopvoiceprint";
        aVar.hmi = 615;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((bmt) this.gJQ.hmg.hmo).fuL = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 615;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSwitchOpVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        bmu com_tencent_mm_protocal_c_bmu = (bmu) ((b) qVar).hmh.hmo;
        if (i2 == 0 || i3 == 0) {
            this.mStatus = com_tencent_mm_protocal_c_bmu.wEr;
            this.sgS = com_tencent_mm_protocal_c_bmu.wPV;
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
