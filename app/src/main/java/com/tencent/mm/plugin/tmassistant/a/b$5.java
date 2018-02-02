package com.tencent.mm.plugin.tmassistant.a;

import com.tencent.mm.g.a.gd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$5 extends c<gd> {
    final /* synthetic */ b sdZ;

    b$5(b bVar) {
        this.sdZ = bVar;
        this.xen = gd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gd gdVar = (gd) bVar;
        x.i("MicroMsg.SubCoreTMAssistant", "resumeDownloadTask");
        gdVar.fwk.fnI = this.sdZ.bFl().ca(gdVar.fwj.fmZ);
        return true;
    }
}
