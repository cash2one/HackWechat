package com.tencent.mm.app;

import com.tencent.mm.g.a.hc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class WorkerProfile$10 extends c<hc> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$10(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = hc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hc hcVar = (hc) bVar;
        if (hcVar == null || hcVar.fxm == null) {
            x.w("MicroMsg.WorkerProfile", "summerdiz GetDisasterInfoEvent event null ret false");
        } else {
            x.i("MicroMsg.WorkerProfile", "summerdiz GetDisasterInfoEvent callback event noticeid[%d], manualauthSucc[%b]", new Object[]{Integer.valueOf(hcVar.fxm.fxn), Boolean.valueOf(hcVar.fxm.fxo)});
            ar.Dm().F(new 1(this, r0, r1));
        }
        return false;
    }
}
