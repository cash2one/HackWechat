package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.boz;
import com.tencent.mm.protocal.c.bpa;

public final class x extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public ajr lNg;

    public x(ajr com_tencent_mm_protocal_c_ajr, int i) {
        this.lNg = com_tencent_mm_protocal_c_ajr;
        a aVar = new a();
        aVar.hmj = new boz();
        aVar.hmk = new bpa();
        aVar.hmi = 537;
        aVar.uri = "/cgi-bin/micromsg-bin/unbindharddevice";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        boz com_tencent_mm_protocal_c_boz = (boz) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_boz.vLR = com_tencent_mm_protocal_c_ajr;
        com_tencent_mm_protocal_c_boz.vGN = i;
    }

    public final int getType() {
        return 537;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.exdevice.NetSceneUnBindHardDevice", "onGYNetEnd netId = %d, errType= %d, errCode = %d , errMsg =%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        i iVar = i.lMM;
        i.ct(0);
        com.tencent.mm.plugin.exdevice.h.b zg = ad.aEk().zg(this.lNg.ksX);
        if (zg != null) {
            if (!(u.aEM().lKw == null || u.aEM().lKw.cF(zg.field_mac))) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "stopChannel Failed!!!");
            }
            if (!ad.aEk().cq(this.lNg.ksX, this.lNg.vJA)) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "deleteByDeviceId Failed!!!");
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "getByDeviceIdServer Failed!!! DeviceIDServer = %s", new Object[]{this.lNg.ksX});
        }
        if (!(i2 == 0 && i3 == 0)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "scene.getType() = %s", new Object[]{Integer.valueOf(537)});
        }
        bpa com_tencent_mm_protocal_c_bpa = (this.gJQ == null || this.gJQ.hmh.hmo == null) ? null : (bpa) this.gJQ.hmh.hmo;
        if (com_tencent_mm_protocal_c_bpa == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.NetSceneUnBindHardDevice", "UnbindHardDevice resp or req is null");
        }
        this.gJT.a(i2, i3, str, this);
    }
}
