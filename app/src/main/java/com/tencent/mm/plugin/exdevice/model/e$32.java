package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.cz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$32 extends c<cz> {
    final /* synthetic */ e lLO;

    e$32(e eVar) {
        this.lLO = eVar;
        this.xen = cz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cz czVar = (cz) bVar;
        e eVar = this.lLO;
        czVar = czVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceConnectLanDeviceEvent: brandName=%s, deviceId=%s, type=%b", new Object[]{czVar.frq.frn, czVar.frq.ffq, Boolean.valueOf(czVar.frq.fro)});
        if (e.yP(czVar.frq.frn)) {
            com.tencent.mm.plugin.exdevice.h.b zg = ad.aEk().zg(czVar.frq.ffq);
            if (zg == null) {
                czVar.frr.frp = false;
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", new Object[]{czVar.frq.ffq});
                return false;
            } else if (zg.field_brandName.equals(czVar.frq.frn)) {
                boolean ae = eVar.lLJ.ae(czVar.frq.ffq, czVar.frq.fro);
                czVar.frr.frp = ae;
                return ae;
            } else {
                czVar.frr.frp = false;
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", new Object[]{zg.field_brandName, czVar.frq.frn});
                return false;
            }
        }
        czVar.frr.frp = false;
        return false;
    }
}
