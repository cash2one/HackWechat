package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class i$3 extends a {
    final /* synthetic */ String tMB;
    final /* synthetic */ List tNB;
    final /* synthetic */ boolean tNy;
    final /* synthetic */ i tNz;

    i$3(i iVar, String str, List list, boolean z) {
        this.tNz = iVar;
        this.tMB = str;
        this.tNB = list;
        this.tNy = z;
    }

    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
        if ((this.object instanceof WepkgPreloadFile) && (baseWepkgProcessTask instanceof WepkgDownloadProcessTask)) {
            WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.object;
            if (wepkgDownloadProcessTask.tNa != RetCode.tLW || bh.ov(wepkgDownloadProcessTask.iEa)) {
                x.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", new Object[]{wepkgDownloadProcessTask.tNa});
                i.a(this.tNz, this.tMB, this.tNB, this.tNy);
                return;
            }
            String str = wepkgPreloadFile.tNm;
            String str2 = wepkgPreloadFile.tMX;
            String str3 = wepkgDownloadProcessTask.iEa;
            WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
            wepkgCrossProcessTask.pK = 4002;
            wepkgCrossProcessTask.tMU.tNm = str;
            wepkgCrossProcessTask.tMU.tMX = str2;
            wepkgCrossProcessTask.tMU.filePath = str3;
            wepkgCrossProcessTask.tMU.tNn = true;
            if (ac.cfw()) {
                wepkgCrossProcessTask.Yr();
            } else {
                WepkgMainProcessService.b(wepkgCrossProcessTask);
            }
            boolean z = wepkgCrossProcessTask.fnI;
            i.a(this.tNz, this.tMB, this.tNB, this.tNy);
            return;
        }
        x.i("MicroMsg.Wepkg.WepkgUpdater", "object instanceof  WepkgPreloadFile is false");
        i.a(this.tNz, this.tMB, this.tNB, this.tNy);
    }
}
