package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ayd;
import com.tencent.mm.protocal.c.aye;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT = null;
    public ayd nFo = null;
    private aye nFp = null;

    public a(int i, long j, String str, String str2, int i2, long j2) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new ayd();
        aVar.hmk = new aye();
        aVar.hmi = 843;
        aVar.uri = "/cgi-bin/micromsg-bin/pstncancelinvite";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        long currentTimeMillis = System.currentTimeMillis();
        this.nFo = (ayd) this.gJQ.hmg.hmo;
        this.nFo.wbh = i;
        this.nFo.wbi = j;
        this.nFo.nko = str;
        this.nFo.wFp = currentTimeMillis;
        this.nFo.wFq = i2;
        this.nFo.wFr = str2;
        this.nFo.wFs = j2;
        x.d("MicroMsg.NetSceneIPCallCancel", "roomId: %d, roomKey: %d, toUsername: %s, timestamp: %d, inviteId: %d, phoneNumber: %s, callseq: %d", Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(currentTimeMillis), Integer.valueOf(i2), str2, Long.valueOf(j2));
    }

    public final int getType() {
        return 843;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallCancel", "errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nFp = (aye) ((b) qVar).hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
