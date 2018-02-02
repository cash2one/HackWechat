package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpo;
import com.tencent.mm.protocal.c.bpp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public String deviceName;
    public String ffq;
    public String frg;
    private com.tencent.mm.ae.b gJQ;
    private e gJT;

    public b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hmj = new bpo();
        aVar.hmk = new bpp();
        aVar.uri = "/cgi-bin/micromsg-bin/updatesafedevice";
        aVar.hmi = 361;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.ffq = str;
        this.deviceName = str2;
        this.frg = str3;
        bpo com_tencent_mm_protocal_c_bpo = (bpo) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bpo.vYQ = str;
        com_tencent_mm_protocal_c_bpo.nfp = str2;
        com_tencent_mm_protocal_c_bpo.vJA = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + i2 + ", errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 361;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bh.ov(this.ffq) || bh.ov(this.deviceName) || bh.ov(this.frg)) {
            x.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
            return -1;
        }
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
