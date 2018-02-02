package com.tencent.mm.plugin.tmassistant.a;

import com.tencent.mm.g.a.ga;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$4 extends c<ga> {
    final /* synthetic */ b sdZ;

    b$4(b bVar) {
        this.sdZ = bVar;
        super(0);
        this.xen = ga.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ga gaVar = (ga) bVar;
        x.i("MicroMsg.SubCoreTMAssistant", "pauseDownloadTask");
        gaVar.fwc.fnI = this.sdZ.bFl().bZ(gaVar.fwb.fmZ);
        return true;
    }
}
