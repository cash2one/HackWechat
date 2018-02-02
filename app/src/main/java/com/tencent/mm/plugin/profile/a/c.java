package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmp;
import com.tencent.mm.protocal.c.bmq;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;

    public c(String str, boolean z) {
        a aVar = new a();
        aVar.hmj = new bmp();
        aVar.hmk = new bmq();
        aVar.uri = "/cgi-bin/mmocbiz-bin/switchbrand";
        aVar.hmi = 1394;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bmp com_tencent_mm_protocal_c_bmp = (bmp) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bmp.vNq = str;
        com_tencent_mm_protocal_c_bmp.wPS = z;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1394;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
        return a(eVar, this.gJQ, this);
    }

    public final bmq bjp() {
        if (this.gJQ == null || this.gJQ.hmh.hmo == null) {
            return null;
        }
        return (bmq) this.gJQ.hmh.hmo;
    }

    public final bmp bjq() {
        if (this.gJQ == null || this.gJQ.hmg.hmo == null) {
            return null;
        }
        return (bmp) this.gJQ.hmg.hmo;
    }
}
