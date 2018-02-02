package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class e$34 extends c<ct> {
    final /* synthetic */ e lLO;

    e$34(e eVar) {
        this.lLO = eVar;
        this.xen = ct.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ct ctVar = (ct) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceBindHardDeviceEvent");
        ctVar = ctVar;
        int i = ctVar.fqX.opType;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "now optype is %d, subscribeFlag is %d", new Object[]{Integer.valueOf(i), Integer.valueOf(ctVar.fqX.fra)});
        if (i == 1) {
            k lVar = new l(ctVar.fqX.fqZ, r1);
            ar.CG().a(lVar, 0);
            ctVar.fqY.frb = lVar;
        } else if (i == 2 && ctVar.fqX.frb != null) {
            ar.CG().c((l) ctVar.fqX.frb);
        }
        return true;
    }
}
