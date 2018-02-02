package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.ej;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$11 extends c<ej> {
    final /* synthetic */ e lLO;

    e$11(e eVar) {
        this.lLO = eVar;
        this.xen = ej.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ej ejVar = (ej) bVar;
        if (ejVar == null || !(ejVar instanceof ej)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTScanDeviceEvent");
            return false;
        }
        ejVar = ejVar;
        if (e.aDX()) {
            ejVar.fsY.frp = true;
            return true;
        }
        ejVar.fsY.frp = false;
        return true;
    }
}
