package com.tencent.mm.plugin.appbrand.page;

import android.webkit.DownloadListener;
import com.tencent.mm.sdk.platformtools.x;

class t$2 implements DownloadListener {
    final /* synthetic */ t jFj;

    t$2(t tVar) {
        this.jFj = tVar;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        x.i("MicroMsg.AppBrandWebView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", new Object[]{str, str4, str2});
    }
}
