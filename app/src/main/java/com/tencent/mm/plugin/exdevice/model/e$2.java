package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dj;
import com.tencent.mm.plugin.exdevice.model.d.5;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class e$2 extends c<dj> {
    final /* synthetic */ e lLO;

    e$2(e eVar) {
        this.lLO = eVar;
        this.xen = dj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        dj djVar = (dj) bVar;
        if (djVar != null && (djVar instanceof dj)) {
            djVar = djVar;
            String str = djVar.frU.frW;
            boolean z = djVar.frU.frT;
            d aEr = ad.aEr();
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "ranging, uuid = %s, op = %s", new Object[]{str, String.valueOf(z)});
            ar.Dm().F(new 5(aEr, str, z));
        }
        return true;
    }
}
