package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.ayq;
import com.tencent.mm.protocal.c.ayr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public final class n extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT = null;
    public ayq nFP = null;
    private ayr nFQ = null;

    public n(int i, long j, long j2, int i2) {
        a aVar = new a();
        aVar.hmj = new ayq();
        aVar.hmk = new ayr();
        aVar.hmi = 723;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        long currentTimeMillis = System.currentTimeMillis();
        this.nFP = (ayq) this.gJQ.hmg.hmo;
        this.nFP.nkp = q.FS();
        this.nFP.wbh = i;
        this.nFP.wbi = j;
        this.nFP.wFs = j2;
        this.nFP.ktm = i2;
        this.nFP.wFp = currentTimeMillis;
        x.i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(currentTimeMillis)});
    }

    public final int getType() {
        return 723;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallShutDown", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.nFQ = (ayr) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
