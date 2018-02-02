package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.ays;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public final class o extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT;
    public ays nFR = null;
    public ayt nFS = null;

    public o(int i, long j, int i2, long j2, boolean z) {
        a aVar = new a();
        aVar.hmj = new ays();
        aVar.hmk = new ayt();
        aVar.hmi = 819;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnsync";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        long currentTimeMillis = System.currentTimeMillis();
        this.nFR = (ays) this.gJQ.hmg.hmo;
        this.nFR.wFM = q.FS();
        this.nFR.wbh = i;
        this.nFR.wbi = j;
        this.nFR.wFp = currentTimeMillis;
        this.nFR.wFN = i2;
        this.nFR.wFs = j2;
        if (z) {
            this.nFR.wFO = 1;
        } else {
            this.nFR.wFO = 0;
        }
        x.i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(this.nFR.wFO), Long.valueOf(currentTimeMillis)});
    }

    public final int getType() {
        return 819;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.nFS = (ayt) ((b) qVar).hmh.hmo;
        this.gJT.a(i2, i3, str, this);
    }
}
