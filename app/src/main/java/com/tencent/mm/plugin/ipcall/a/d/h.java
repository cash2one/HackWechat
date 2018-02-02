package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ayh;
import com.tencent.mm.protocal.c.ayi;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT = null;
    public ayh nFD = null;
    private ayi nFE = null;

    public h(int i, long j, long j2) {
        a aVar = new a();
        aVar.hmj = new ayh();
        aVar.hmk = new ayi();
        aVar.hmi = 824;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnheartbeat";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        long currentTimeMillis = System.currentTimeMillis();
        this.nFD = (ayh) this.gJQ.hmg.hmo;
        this.nFD.wbh = i;
        this.nFD.wbi = j;
        this.nFD.wFs = j2;
        this.nFD.wFp = currentTimeMillis;
        x.d("MicroMsg.NetSceneIPCallHeartBeat", "heartbeat, roomId: %d, roomKey: %d, callSeq: %d, timestamp: %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(currentTimeMillis));
    }

    public final int getType() {
        return 824;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallHeartBeat", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nFE = (ayi) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
