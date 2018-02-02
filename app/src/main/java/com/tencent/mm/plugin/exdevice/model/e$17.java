package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.cx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$17 extends c<cx> {
    final /* synthetic */ e lLO;

    e$17(e eVar) {
        this.lLO = eVar;
        this.xen = cx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cx.b bVar2;
        cx.b bVar3;
        boolean z;
        cx cxVar = (cx) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceIsBoundEvent: deviceType(%s), deviceId(%s)", new Object[]{cxVar.fri.frg, cxVar.fri.ffq});
        if (cxVar.fri.frg == null || cxVar.fri.ffq == null) {
            bVar2 = cxVar.frj;
        } else {
            com.tencent.mm.plugin.exdevice.h.b co = ad.aEk().co(cxVar.fri.ffq, cxVar.fri.frg);
            bVar2 = cxVar.frj;
            if (co != null) {
                bVar3 = bVar2;
                z = true;
                bVar3.frk = z;
                return true;
            }
        }
        bVar3 = bVar2;
        z = false;
        bVar3.frk = z;
        return true;
    }
}
