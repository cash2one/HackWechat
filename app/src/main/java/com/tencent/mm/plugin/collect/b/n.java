package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.li;
import com.tencent.mm.protocal.c.lj;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends k implements com.tencent.mm.network.k {
    private final String TAG = "MicroMsg.NetSceneMDRcvVoice";
    private b gJQ;
    private e gJT;
    public lj liX;

    public n(int i, com.tencent.mm.bq.b bVar, String str) {
        a aVar = new a();
        aVar.hmj = new li();
        aVar.hmk = new lj();
        aVar.hmi = 1317;
        aVar.uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        li liVar = (li) this.gJQ.hmg.hmo;
        liVar.nZd = i;
        liVar.vTS = 1;
        liVar.ljh = str;
        liVar.vTQ = null;
        liVar.vTR = bVar;
        x.i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", new Object[]{Integer.valueOf(i), str});
    }

    public final int getType() {
        return 1317;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMDRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.liX = (lj) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[]{Integer.valueOf(this.liX.liH), this.liX.liI, Integer.valueOf(this.liX.vTS)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
