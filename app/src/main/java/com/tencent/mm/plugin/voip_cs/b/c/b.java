package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.btp;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.b gJQ;
    private e gJT;

    public b(long j, long j2) {
        a aVar = new a();
        aVar.hmj = new bto();
        aVar.hmk = new btp();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipheartbeat";
        aVar.hmi = 795;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bto com_tencent_mm_protocal_c_bto = (bto) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bto.wUT = j;
        com_tencent_mm_protocal_c_bto.wbi = j2;
        com_tencent_mm_protocal_c_bto.wFp = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSHeartBeat", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 795;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
