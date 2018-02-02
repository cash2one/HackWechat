package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class e$33 extends c<dz> {
    final /* synthetic */ e lLO;

    e$33(e eVar) {
        this.lLO = eVar;
        this.xen = dz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dz dzVar = (dz) bVar;
        e eVar = this.lLO;
        dzVar = dzVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceSendDataToLanDeviceEvent: brandName=%s, deviceId=%s", new Object[]{dzVar.fsB.frn, dzVar.fsB.ffq});
        if (!e.yP(dzVar.fsB.frn) || bh.ov(dzVar.fsB.data)) {
            dzVar.fsC.frp = false;
            return false;
        } else if (ad.aEk().zg(dzVar.fsB.ffq) == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
            dzVar.fsC.frp = false;
            return false;
        } else {
            dzVar.fsC.frp = eVar.lLJ.cn(dzVar.fsB.ffq, dzVar.fsB.data);
            return true;
        }
    }
}
