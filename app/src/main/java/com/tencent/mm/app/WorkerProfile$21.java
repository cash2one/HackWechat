package com.tencent.mm.app;

import com.tencent.mm.g.a.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.ar;

class WorkerProfile$21 extends c<e> {
    Runnable fgE;
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$21(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.fgE = new 1(this);
        this.xen = e.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!((e) bVar).fmQ.fmR && ar.Hj()) {
            ar.Dm().F(this.fgE);
        }
        return false;
    }
}
