package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.hb;
import com.tencent.mm.protocal.c.hc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    private String lMY;
    private long lMZ;
    private String lNa;
    private long lNb;

    public m(long j, String str, String str2, long j2) {
        this.lMZ = j;
        this.lNa = str;
        this.lMY = str2;
        this.lNb = j2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBindUnauthDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        if (i2 == 0 && i3 == 0) {
            Object obj;
            hc hcVar = (hc) this.gJQ.hmh.hmo;
            ajr com_tencent_mm_protocal_c_ajr = hcVar.vLR;
            String str2 = null;
            String str3 = null;
            if (com_tencent_mm_protocal_c_ajr != null) {
                str2 = com_tencent_mm_protocal_c_ajr.ksX;
                str3 = com_tencent_mm_protocal_c_ajr.vJA;
            }
            x.d("MicroMsg.NetSceneBindUnauthDevice", "unauth bind deviceId = %s, deviceType = %s", new Object[]{str2, str3});
            if (ad.aEk().cp(str3, str2) != null) {
                x.i("MicroMsg.NetSceneBindUnauthDevice", "delete local deviceinfo : %s, ret : %b", new Object[]{str3, Boolean.valueOf(ad.aEk().cq(str2, str3))});
                if (ad.aEk().cq(str2, str3)) {
                    obj = 1;
                } else {
                    obj = null;
                }
            } else {
                obj = 1;
            }
            c bVar = new com.tencent.mm.plugin.exdevice.h.b();
            bVar.field_connProto = this.lMY;
            bVar.field_connStrategy = 1;
            bVar.field_closeStrategy = 1;
            bVar.field_url = "";
            f.a(bVar, com_tencent_mm_protocal_c_ajr, hcVar.vLS);
            if (bVar.field_mac == 0) {
                x.d("MicroMsg.NetSceneBindUnauthDevice", "onSceneEnd, mac of hardDeviceAttr is 0 so set a local mac.");
                bVar.field_mac = this.lMZ;
            }
            if (obj != null) {
                ad.aEk().b(bVar);
            } else {
                ad.aEk().e(bVar);
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1262;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        a aVar = new a();
        aVar.hmj = new hb();
        aVar.hmk = new hc();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/bindunauthdevice";
        aVar.hmi = 1262;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        hb hbVar = (hb) this.gJQ.hmg.hmo;
        hbVar.mac = com.tencent.mm.plugin.exdevice.j.b.cL(this.lMZ);
        hbVar.vMM = this.lNa;
        hbVar.vML = this.lMY;
        hbVar.vMN = this.lNb;
        return a(eVar, this.gJQ, this);
    }
}
