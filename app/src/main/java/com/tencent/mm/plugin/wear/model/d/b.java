package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzh;
import com.tencent.mm.protocal.c.bzi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ba;

public final class b extends k implements com.tencent.mm.network.k {
    private e gJT;
    private com.tencent.mm.ae.b hFi;

    public b(String str) {
        a aVar = new a();
        aVar.uri = "/cgi-bin/micromsg-bin/sendyo";
        aVar.hmj = new bzh();
        aVar.hmk = new bzi();
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hFi = aVar.JZ();
        bzh com_tencent_mm_protocal_c_bzh = (bzh) this.hFi.hmg.hmo;
        com_tencent_mm_protocal_c_bzh.nko = str;
        com_tencent_mm_protocal_c_bzh.wyU = com_tencent_mm_protocal_c_bzh.pbl;
        com_tencent_mm_protocal_c_bzh.pbl = (int) ba.hR(str);
        com_tencent_mm_protocal_c_bzh.ktN = 63;
        com_tencent_mm_protocal_c_bzh.wZc = 1;
        com_tencent_mm_protocal_c_bzh.ksO = 1;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 976;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }
}
