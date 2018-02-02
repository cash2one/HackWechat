package com.tencent.mm.plugin.tmassistant.a;

import com.tencent.mm.g.a.gb;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class b$3 extends c<gb> {
    final /* synthetic */ b sdZ;

    b$3(b bVar) {
        this.sdZ = bVar;
        this.xen = gb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gb gbVar = (gb) bVar;
        FileDownloadTaskInfo bY = this.sdZ.bFl().bY(gbVar.fwd.fmZ);
        gbVar.fwe.url = bY.url;
        gbVar.fwe.status = bY.status;
        gbVar.fwe.path = bY.path;
        gbVar.fwe.fqR = bY.fqR;
        gbVar.fwe.fwf = bY.fwf;
        gbVar.fwe.fwg = bY.fwg;
        return true;
    }
}
