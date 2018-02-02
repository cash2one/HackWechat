package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.x;

class WepkgDownloadProcessTask$1 implements IWepkgUpdateCallback {
    final /* synthetic */ WepkgDownloadProcessTask tNb;

    WepkgDownloadProcessTask$1(WepkgDownloadProcessTask wepkgDownloadProcessTask) {
        this.tNb = wepkgDownloadProcessTask;
    }

    public final void a(String str, String str2, RetCode retCode) {
        x.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", retCode);
        this.tNb.fME = str;
        this.tNb.iEa = str2;
        this.tNb.tNa = retCode;
        this.tNb.afj();
        WepkgDownloadProcessTask.a(this.tNb);
    }
}
