package com.tencent.mm.plugin.tmassistant.a;

import com.tencent.mm.g.a.gc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$2 extends c<gc> {
    final /* synthetic */ b sdZ;

    b$2(b bVar) {
        this.sdZ = bVar;
        this.xen = gc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gc gcVar = (gc) bVar;
        x.i("MicroMsg.SubCoreTMAssistant", "removeDownloadTask");
        gcVar.fwi.count = this.sdZ.bFl().bX(gcVar.fwh.fmZ);
        return true;
    }
}
