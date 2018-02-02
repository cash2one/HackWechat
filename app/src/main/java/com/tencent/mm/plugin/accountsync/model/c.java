package com.tencent.mm.plugin.accountsync.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfz;
import com.tencent.mm.protocal.c.bga;

public final class c extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT = null;

    public c(bfz com_tencent_mm_protocal_c_bfz) {
        a aVar = new a();
        aVar.hmj = com_tencent_mm_protocal_c_bfz;
        aVar.hmk = new bga();
        aVar.uri = "/cgi-bin/micromsg-bin/sendphoto2fbwall";
        aVar.hmi = 433;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 433;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
