package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.b.bq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$18 extends c<cw> {
    final /* synthetic */ e lLO;

    e$18(e eVar) {
        this.lLO = eVar;
        this.xen = cw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cw cwVar = (cw) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceHasAbilityEvent: deviceType(%s), deviceId(%s)", cwVar.fre.frg, cwVar.fre.ffq);
        if (cwVar.fre.frg == null || cwVar.fre.ffq == null) {
            cwVar.frf.frh = false;
        } else {
            bq cp = ad.aEk().cp(cwVar.fre.frg, cwVar.fre.ffq);
            if (cp != null) {
                String str = cp.gfT;
                cw.b bVar2 = cwVar.frf;
                ad.aEk();
                bVar2.frh = com.tencent.mm.plugin.exdevice.h.c.zh(str);
            } else {
                cwVar.frf.frh = false;
            }
        }
        return true;
    }
}
