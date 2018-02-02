package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.bh;

class i$2 extends a {
    final /* synthetic */ String tMB;
    final /* synthetic */ a tNA;
    final /* synthetic */ boolean tNy;
    final /* synthetic */ i tNz;

    i$2(i iVar, a aVar, boolean z, String str) {
        this.tNz = iVar;
        this.tNA = aVar;
        this.tNy = z;
        this.tMB = str;
    }

    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
        if (baseWepkgProcessTask instanceof WepkgDownloadProcessTask) {
            WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
            if (wepkgDownloadProcessTask.tNa != RetCode.tLW || bh.ov(wepkgDownloadProcessTask.fME) || bh.ov(wepkgDownloadProcessTask.iEa)) {
                i.l(this.tNy, this.tMB);
                return;
            } else {
                h.a(wepkgDownloadProcessTask.fME, wepkgDownloadProcessTask.iEa, true, this.tNA);
                return;
            }
        }
        i.l(this.tNy, this.tMB);
    }
}
