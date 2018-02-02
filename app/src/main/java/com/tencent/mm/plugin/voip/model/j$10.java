package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.g.a.so;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class j$10 extends c<so> {
    final /* synthetic */ j smu;

    j$10(j jVar) {
        this.smu = jVar;
        this.xen = so.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        so soVar = (so) bVar;
        if (soVar instanceof so) {
            soVar.fKm.fKn = com.tencent.mm.plugin.voip.b.b.yT(j.a(this.smu).mState);
            soVar.fKm.fKo = j.c(this.smu) != null;
            soVar.fKm.fKp = true;
            soVar.fKm.talker = j.d(this.smu);
        }
        return false;
    }
}
