package com.tencent.mm.app;

import com.tencent.mm.g.a.d;
import com.tencent.mm.g.a.d$a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WorkerProfile$23 extends c<d> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$23(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = d.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        d dVar = (d) bVar;
        if (!(dVar == null || dVar.fmN == null)) {
            d$a com_tencent_mm_g_a_d_a = dVar.fmN;
            g.Dh();
            com_tencent_mm_g_a_d_a.fmO = a.Cx();
            dVar.fmN.isReady = g.Dh().Cy();
            dVar.fmN.fmP = g.Dh().gPy;
            x.i("MicroMsg.WorkerProfile", "summerasyncinit AccountInitializeStatus[%d, %b, %b, %b]", new Object[]{Integer.valueOf(dVar.fmN.cOY), Boolean.valueOf(dVar.fmN.fmO), Boolean.valueOf(dVar.fmN.isReady), Boolean.valueOf(dVar.fmN.fmP)});
            if (dVar.fmN.fmO && !(dVar.fmN.isReady && dVar.fmN.fmP)) {
                com.tencent.mm.plugin.report.service.g.pQN.a(598, dVar.fmN.isReady ? 9 : 10, 1, false);
                com.tencent.mm.plugin.report.service.g.pQN.a(598, com.tencent.mm.sdk.a.b.foreground ? 11 : 12, 1, false);
                com.tencent.mm.plugin.report.service.g.pQN.a(598, (long) (dVar.fmN.cOY + 30), 1, false);
            }
        }
        return false;
    }
}
