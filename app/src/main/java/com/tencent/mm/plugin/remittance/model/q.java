package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.ly;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    public lz pKG;

    public q(String str, String str2, String str3, String str4, long j, String str5) {
        a aVar = new a();
        aVar.hmj = new ly();
        aVar.hmk = new lz();
        aVar.hmi = 1779;
        aVar.uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        ly lyVar = (ly) this.hNJ.hmg.hmo;
        lyVar.fwY = str;
        lyVar.vUB = str2;
        lyVar.pLr = str3;
        lyVar.pLn = str4;
        lyVar.pMC = j;
        lyVar.vUk = str5;
        x.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", new Object[]{str, str2, Long.valueOf(j)});
    }

    public final int getType() {
        return 1779;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pKG = (lz) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.pKG.liH), this.pKG.liI});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
