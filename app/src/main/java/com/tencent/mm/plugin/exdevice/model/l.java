package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.gt;
import com.tencent.mm.protocal.c.gu;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT = null;

    public l(String str, int i) {
        a aVar = new a();
        aVar.hmj = new gt();
        aVar.hmk = new gu();
        aVar.uri = "/cgi-bin/micromsg-bin/bindharddevice";
        aVar.hmi = 536;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        gt gtVar = (gt) this.gJQ.hmg.hmo;
        gtVar.vLx = bh.ou(str);
        gtVar.vLQ = bh.e(Integer.valueOf(i));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneBindHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        if (i2 == 0 && i3 == 0) {
            int i4;
            gu aEd = aEd();
            x.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", new Object[]{aEd.vLR.ksX, aEd.vLR.vJA});
            String str2 = "MicroMsg.exdevice.NetSceneBindHardDevice";
            String str3 = "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s";
            Object[] objArr = new Object[6];
            objArr[0] = aEd.vLS.vJh;
            objArr[1] = aEd.vLS.wqJ;
            objArr[2] = aEd.vLS.vLs;
            objArr[3] = aEd.vLS.wqK;
            objArr[4] = Integer.valueOf(aEd.vLS.wqL);
            objArr[5] = aEd.vGN == 0 ? "sync" : "async";
            x.i(str2, str3, objArr);
            if (ad.aEk().cp(aEd.vLS.wqJ, aEd.vLR.ksX) != null) {
                x.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", new Object[]{aEd.vLS.wqJ, Boolean.valueOf(ad.aEk().cq(aEd.vLR.ksX, aEd.vLS.wqJ))});
                if (ad.aEk().cq(aEd.vLR.ksX, aEd.vLS.wqJ)) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
            } else {
                i4 = 1;
            }
            c bVar = new com.tencent.mm.plugin.exdevice.h.b();
            f.a(bVar, aEd.vLR, aEd.vLS);
            bVar.field_url = "";
            f.a cz = u.aEL().cz(bVar.field_mac);
            if (cz != null && cz.fsg == 2) {
                x.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
                ad.aEr();
                d.cn(bVar.field_mac);
                f aEL = u.aEL();
                long j = bVar.field_mac;
                if (aEL.lQi.containsKey(Long.valueOf(j))) {
                    aEL.lQi.remove(Long.valueOf(j));
                    x.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", new Object[]{Long.valueOf(j)});
                } else {
                    x.i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", new Object[]{Long.valueOf(j)});
                }
            }
            if (i4 != 0) {
                ad.aEk().b(bVar);
            } else {
                ad.aEk().e(bVar);
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 536;
    }

    public final gu aEd() {
        if (this.gJQ == null || this.gJQ.hmh.hmo == null) {
            return null;
        }
        return (gu) this.gJQ.hmh.hmo;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
