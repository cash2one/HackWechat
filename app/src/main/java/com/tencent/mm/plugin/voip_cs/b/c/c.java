package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.btq;
import com.tencent.mm.protocal.c.btr;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;

    public c(int i, String str, int i2, byte[] bArr, byte[] bArr2, String str2) {
        a aVar = new a();
        aVar.hmj = new btq();
        aVar.hmk = new btr();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipinvite";
        aVar.hmi = 823;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        btq com_tencent_mm_protocal_c_btq = (btq) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_btq.wFq = i;
        com_tencent_mm_protocal_c_btq.wUU = str;
        com_tencent_mm_protocal_c_btq.vWK = i2;
        com_tencent_mm_protocal_c_btq.wUV = com.tencent.mm.bq.b.bc(bArr);
        com_tencent_mm_protocal_c_btq.wUW = com.tencent.mm.bq.b.bc(bArr2);
        com_tencent_mm_protocal_c_btq.wFp = System.currentTimeMillis();
        if (str2 != null && !str2.equals("")) {
            com_tencent_mm_protocal_c_btq.wUX = str2;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSInvite", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 823;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
