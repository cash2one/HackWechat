package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bty;
import com.tencent.mm.protocal.c.btz;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;

    public f(long j, long j2, int i) {
        a aVar = new a();
        aVar.hmj = new bty();
        aVar.hmk = new btz();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipsync";
        aVar.hmi = 818;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bty com_tencent_mm_protocal_c_bty = (bty) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bty.wUT = j;
        com_tencent_mm_protocal_c_bty.wbi = j2;
        com_tencent_mm_protocal_c_bty.wVd = i;
        com_tencent_mm_protocal_c_bty.wFp = System.currentTimeMillis();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 818;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
