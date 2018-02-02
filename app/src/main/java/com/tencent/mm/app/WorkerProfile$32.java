package com.tencent.mm.app;

import com.tencent.mm.g.a.pj;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class WorkerProfile$32 extends c<pj> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$32(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = pj.class.getName().hashCode();
    }

    private boolean a(pj pjVar) {
        byte[] bArr = pjVar.fHn.data;
        if (bArr != null) {
            x.i("MicroMsg.WorkerProfile", "summerbadcr SilenceNotifyEvent callback data len:%d", new Object[]{Integer.valueOf(bArr.length)});
            bx bxVar = new bx();
            try {
                bxVar.aF(bArr);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                x.e("MicroMsg.WorkerProfile", "summerbadcr SilenceNotifyEvent callback parse exception:" + e.getMessage());
            }
            ar.Dm().F(new 1(this, bxVar));
        }
        return false;
    }
}
