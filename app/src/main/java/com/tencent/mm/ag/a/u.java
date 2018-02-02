package com.tencent.mm.ag.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bae;
import com.tencent.mm.protocal.c.baf;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;

    public u(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new bae();
        aVar.hmk = new baf();
        aVar.uri = "/cgi-bin/mmocbiz-bin/quitbizchat";
        aVar.hmi = 1358;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bae com_tencent_mm_protocal_c_bae = (bae) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bae.vNq = str;
        com_tencent_mm_protocal_c_bae.vNk = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneQuitBizChat", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1358;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.brandservice.NetSceneQuitBizChat", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
