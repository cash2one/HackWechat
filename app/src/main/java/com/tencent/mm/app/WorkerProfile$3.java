package com.tencent.mm.app;

import com.tencent.mm.g.a.ox;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.contact.e;

class WorkerProfile$3 extends c<ox> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$3(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = ox.class.getName().hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean a(b bVar) {
        ox oxVar = (ox) bVar;
        e.a(oxVar.fGO.intent, oxVar.fGO.username);
        return false;
    }
}
