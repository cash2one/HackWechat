package com.tencent.mm.app;

import com.tencent.mm.g.a.or;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;

class WorkerProfile$34 extends c<or> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$34(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = or.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        or orVar = (or) bVar;
        for (String jVar : bh.F(orVar.fGI.fGJ.split(","))) {
            ar.CG().a(new j(jVar, orVar.fGI.content, orVar.fGI.type), 0);
        }
        return false;
    }
}
