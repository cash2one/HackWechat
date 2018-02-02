package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.db;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$46 extends c<db> {
    final /* synthetic */ e lLO;

    e$46(e eVar) {
        this.lLO = eVar;
        this.xen = db.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = ((db) bVar).frv.frw;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "------handleGetBoundDeviceEvent------ check if need to get bound device after auth");
        if (i.lMM.eI(z)) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "do get bound device after auth");
            i.lMM.a(null, null);
        }
        return true;
    }
}
