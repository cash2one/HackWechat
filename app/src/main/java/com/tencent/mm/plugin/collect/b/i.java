package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lb;
import com.tencent.mm.protocal.c.lc;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    public String fpQ;
    private e gJT;
    private b hNJ;
    public lc liD;

    public i(int i, com.tencent.mm.bq.b bVar, String str) {
        a aVar = new a();
        aVar.hmj = new lb();
        aVar.hmk = new lc();
        aVar.hmi = 1384;
        aVar.uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        lb lbVar = (lb) this.hNJ.hmg.hmo;
        lbVar.nZd = i;
        lbVar.vTS = 1;
        lbVar.ljh = str;
        lbVar.vTQ = null;
        lbVar.vTR = bVar;
        this.fpQ = str;
        x.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", new Object[]{Integer.valueOf(i), str});
    }

    public final int getType() {
        return 1384;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.liD = (lc) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[]{Integer.valueOf(this.liD.liH), this.liD.liI, Integer.valueOf(this.liD.vTS)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
