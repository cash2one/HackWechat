package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bhl;
import com.tencent.mm.protocal.c.bhm;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class ai extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gJT;

    public ai(String str, String str2, bdn com_tencent_mm_protocal_c_bdn) {
        a aVar = new a();
        aVar.hmj = new bhl();
        aVar.hmk = new bhm();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetpasswd";
        aVar.hmi = 383;
        aVar.hml = 180;
        aVar.hmm = 1000000180;
        this.gJQ = aVar.JZ();
        bhl com_tencent_mm_protocal_c_bhl = (bhl) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bhl.lOf = bh.VB(str);
        com_tencent_mm_protocal_c_bhl.vZK = str2;
        com_tencent_mm_protocal_c_bhl.vJa = com_tencent_mm_protocal_c_bdn;
        x.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, authkey:%s", new Object[]{str, str2, bh.bv(n.a(com_tencent_mm_protocal_c_bdn))});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 383;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gJT.a(i2, i3, str, this);
    }
}
