package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgz;
import com.tencent.mm.protocal.c.bha;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public com.tencent.mm.ae.b gJQ;
    private e gJT;

    public b(String str, int i) {
        a aVar = new a();
        aVar.hmj = new bgz();
        aVar.hmk = new bha();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
        aVar.hmi = 1363;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bgz com_tencent_mm_protocal_c_bgz = (bgz) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bgz.vNq = str;
        com_tencent_mm_protocal_c_bgz.wLa = i;
        com_tencent_mm_protocal_c_bgz.wLb = 4;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1363;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
