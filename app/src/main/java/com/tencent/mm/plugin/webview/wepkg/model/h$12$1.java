package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader$IWepkgUpdateCallback;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader$IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.webview.wepkg.model.h.12;
import com.tencent.mm.sdk.platformtools.x;

class h$12$1 implements WePkgDownloader$IWepkgUpdateCallback {
    final /* synthetic */ 12 tNw;

    h$12$1(12 12) {
        this.tNw = 12;
    }

    public final void a(String str, String str2, RetCode retCode) {
        x.i("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "onPkgUpdatingCallback errCode:%s", new Object[]{retCode});
        this.tNw.tNp.fME = str;
        this.tNw.tNp.iEa = str2;
        this.tNw.tNp.tNa = retCode;
        if (this.tNw.tNo != null) {
            this.tNw.tNo.a(this.tNw.tNp);
        }
    }
}
