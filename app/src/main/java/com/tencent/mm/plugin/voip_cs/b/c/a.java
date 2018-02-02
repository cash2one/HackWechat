package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.btm;
import com.tencent.mm.protocal.c.btn;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;

    public a(int i, long j, long j2, String str, int i2) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new btm();
        aVar.hmk = new btn();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoiphangup";
        aVar.hmi = 880;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        btm com_tencent_mm_protocal_c_btm = (btm) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_btm.wFq = i;
        com_tencent_mm_protocal_c_btm.wUT = j;
        com_tencent_mm_protocal_c_btm.wbi = j2;
        com_tencent_mm_protocal_c_btm.wUU = str;
        com_tencent_mm_protocal_c_btm.whD = i2;
        com_tencent_mm_protocal_c_btm.wFp = System.currentTimeMillis();
    }

    public final int getType() {
        return 880;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSHangUp", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }
}
