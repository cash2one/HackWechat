package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dp;
import com.tencent.mm.plugin.exdevice.model.d.11;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class e$8 extends c<dp> {
    final /* synthetic */ e lLO;

    e$8(e eVar) {
        this.lLO = eVar;
        this.xen = dp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleDeviceOPFromJSAPIEvent: %d", new Object[]{Integer.valueOf(((dp) bVar).fsm.op)});
        if (((dp) bVar).fsm.op == 1) {
            d aEr = ad.aEr();
            if (aEr.lKB == null) {
                aEr.lKB = new com.tencent.mm.plugin.exdevice.service.c();
                aEr.lKB.lQd = new 11(aEr, 0);
                aEr.lKB.cx(ac.getContext());
            }
        }
        return true;
    }
}
