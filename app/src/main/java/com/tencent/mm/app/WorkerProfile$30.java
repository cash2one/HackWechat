package com.tencent.mm.app;

import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.ca.d;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class WorkerProfile$30 extends c<rl> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$30(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = rl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rl rlVar = (rl) bVar;
        if (rlVar.fJm.fJn == 3) {
            NotifyReceiver.wF();
        }
        d.clq().de(rlVar.fJm.className, rlVar.fJm.fJn);
        return false;
    }
}
