package com.tencent.mm.plugin.webview.wepkg.downloader;

import com.tencent.mm.a.g;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader$IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.utils.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class WePkgDownloader$1 implements a {
    final /* synthetic */ WePkgDownloader tLV;

    WePkgDownloader$1(WePkgDownloader wePkgDownloader) {
        this.tLV = wePkgDownloader;
    }

    public final synchronized void a(g gVar) {
        String str;
        RetCode retCode;
        d.bVe().Qa(gVar.tLH.tMe);
        if (gVar.mStatus == 1) {
            str = gVar.tLH.mFilePath;
            if (bh.ov(str) || !new File(str).exists()) {
                x.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, pkgPath is null or nil");
                retCode = RetCode.tLX;
            } else {
                if (bh.ou(g.bV(str)).equalsIgnoreCase(gVar.tLH.jcx)) {
                    retCode = RetCode.tLW;
                } else {
                    x.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, file.md5(%s) != net.md5(%s)", new Object[]{g.bV(str), gVar.tLH.jcx});
                    b.deleteFile(str);
                    RetCode retCode2 = RetCode.tLY;
                    gVar.lJY = HardCoderJNI.FUNC_TERMINATE_APP;
                    retCode = retCode2;
                }
            }
        } else {
            retCode = RetCode.tMa;
        }
        x.i("MicroMsg.Wepkg.WepkgDownloader", "download callback retCode:" + retCode);
        WePkgDownloader$IWepkgUpdateCallback wePkgDownloader$IWepkgUpdateCallback = (WePkgDownloader$IWepkgUpdateCallback) WePkgDownloader.a(this.tLV).remove(gVar.tLH.tMe);
        if (wePkgDownloader$IWepkgUpdateCallback != null) {
            wePkgDownloader$IWepkgUpdateCallback.a(gVar.tLH.tMf, gVar.tLH.mFilePath, retCode);
        } else {
            x.i("MicroMsg.Wepkg.WepkgDownloader", "download callback invalid");
            a.b("CallbackInvalid", gVar.tLH.mUrl, gVar.tLH.tMf, null, -1, 0, null);
        }
        if (gVar.tLH.lsy == 1) {
            str = gVar.tLH.tMf;
            WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
            wepkgCrossProcessTask.pK = 3008;
            wepkgCrossProcessTask.tMS.tNm = str;
            if (ac.cfw()) {
                wepkgCrossProcessTask.Yr();
            } else {
                WepkgMainProcessService.b(wepkgCrossProcessTask);
            }
        } else {
            str = gVar.tLH.tMf;
            String str2 = gVar.tLH.tMg;
            WepkgMainProcessTask wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
            wepkgCrossProcessTask2.pK = 4005;
            wepkgCrossProcessTask2.tMU.tNm = str;
            wepkgCrossProcessTask2.tMU.tMX = str2;
            if (ac.cfw()) {
                wepkgCrossProcessTask2.Yr();
            } else {
                WepkgMainProcessService.b(wepkgCrossProcessTask2);
            }
        }
        WePkgDownloader.b(gVar);
    }
}
