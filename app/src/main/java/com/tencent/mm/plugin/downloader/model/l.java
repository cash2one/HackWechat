package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.g.a.fy;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.g.a.gd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

final class l extends j {
    private c hiA = new 1(this);

    public l(c cVar) {
        super(cVar);
        a.xef.b(this.hiA);
    }

    public final long a(g gVar) {
        b fyVar = new fy();
        fyVar.fvP.fvR = gVar.iFI;
        fyVar.fvP.fvS = gVar.lsv;
        fyVar.fvP.fileSize = gVar.lsw;
        fyVar.fvP.fileName = gVar.mFileName;
        fyVar.fvP.fvT = gVar.lsx;
        fyVar.fvP.fileType = gVar.lsy;
        fyVar.fvP.appId = gVar.mAppId;
        fyVar.fvP.fvU = gVar.lsz;
        fyVar.fvP.fvV = gVar.lsA;
        fyVar.fvP.fvW = gVar.lsB;
        fyVar.fvP.packageName = gVar.mPackageName;
        fyVar.fvP.fvX = gVar.lsC;
        fyVar.fvP.scene = gVar.irz;
        a.xef.m(fyVar);
        return fyVar.fvQ.fmZ;
    }

    public final int bX(long j) {
        b gcVar = new gc();
        gcVar.fwh.fmZ = j;
        a.xef.m(gcVar);
        return gcVar.fwi.count;
    }

    public final FileDownloadTaskInfo bY(long j) {
        b gbVar = new gb();
        gbVar.fwd.fmZ = j;
        a.xef.m(gbVar);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j;
        fileDownloadTaskInfo.url = gbVar.fwe.url;
        fileDownloadTaskInfo.status = gbVar.fwe.status;
        fileDownloadTaskInfo.path = gbVar.fwe.path;
        fileDownloadTaskInfo.fqR = gbVar.fwe.fqR;
        fileDownloadTaskInfo.fwf = gbVar.fwe.fwf;
        fileDownloadTaskInfo.fwg = gbVar.fwe.fwg;
        return fileDownloadTaskInfo;
    }

    public final boolean bZ(long j) {
        b gaVar = new ga();
        gaVar.fwb.fmZ = j;
        a.xef.m(gaVar);
        return gaVar.fwc.fnI;
    }

    public final boolean ca(long j) {
        b gdVar = new gd();
        gdVar.fwj.fmZ = j;
        a.xef.m(gdVar);
        return gdVar.fwk.fnI;
    }
}
