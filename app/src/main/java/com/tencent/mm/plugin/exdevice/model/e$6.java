package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.da;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$6 extends c<da> {
    final /* synthetic */ e lLO;

    e$6(e eVar) {
        this.lLO = eVar;
        this.xen = da.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        da daVar = (da) bVar;
        com.tencent.mm.plugin.exdevice.h.b cp = ad.aEk().cp(daVar.frs.fru, daVar.frs.ffq);
        if (cp == null || (cp.field_connStrategy & 16) != 0) {
            daVar.frt.frp = false;
        } else {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "CONNECT_STRATEGY_IGNORE_ON_CHAT disable, (%s) do not disconnect ble device(%s)", new Object[]{daVar.frs.fru, daVar.frs.ffq});
            daVar.frt.frp = true;
        }
        return true;
    }
}
