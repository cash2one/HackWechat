package com.tencent.mm.app;

import com.tencent.mm.g.a.si;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WorkerProfile$33 extends c<si> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$33(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = si.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.WorkerProfile", "upload sql file");
        com.tencent.mm.z.d.b.IP().ir(com.tencent.mm.z.d.b.ip(com.tencent.mm.z.d.b.hjd + "MMSQL.trace"));
        return false;
    }
}
