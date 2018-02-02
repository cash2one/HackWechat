package com.tencent.mm.app;

import com.tencent.mm.plugin.report.b.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class WorkerProfile$28 implements Runnable {
    final /* synthetic */ int fgK;
    final /* synthetic */ byte[] fgL;
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$28(WorkerProfile workerProfile, int i, byte[] bArr) {
        this.fgz = workerProfile;
        this.fgK = i;
        this.fgL = bArr;
    }

    public final void run() {
        if (!ar.GZ()) {
            x.i("MicroMsg.WorkerProfile", "summeranrt onReportKVDataReady channel:" + this.fgK);
            ar.CG().a(new e(this.fgL, this.fgK), 0);
        }
    }
}
