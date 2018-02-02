package com.tencent.mm.app;

import com.tencent.mm.R;
import com.tencent.mm.aq.n;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.ar;

class WorkerProfile$31 extends c<ik> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$31(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = ik.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ik ikVar = (ik) bVar;
        final String str = ikVar.fyP.imagePath;
        final String str2 = ikVar.fyP.toUser;
        final boolean booleanValue = ikVar.fyP.fyQ.booleanValue();
        final int i = ikVar.fyP.fyR;
        if (ikVar.fyP.fyS.booleanValue()) {
            ar.Dm().F(new Runnable(this) {
                final /* synthetic */ WorkerProfile$31 fgQ;

                public final void run() {
                    n.Pn().a(0, i, str, str2, booleanValue, R.g.bAH);
                }
            });
        }
        return false;
    }
}
