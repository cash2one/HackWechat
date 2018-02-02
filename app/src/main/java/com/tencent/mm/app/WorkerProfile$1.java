package com.tencent.mm.app;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class WorkerProfile$1 extends a {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$1(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
    }

    public final void eq(int i) {
        if ((i == 4 || i == 6) && ar.Hj() && g.Dh().gPy && !ar.Cs()) {
            x.i("MicroMsg.WorkerProfile", "dkmsg Network connected , try send msg.");
            ar.CG().a(new j(), 0);
        }
    }
}
