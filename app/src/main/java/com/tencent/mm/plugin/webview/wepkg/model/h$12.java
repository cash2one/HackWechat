package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.sdk.platformtools.bh;

class h$12 implements Runnable {
    final /* synthetic */ String jkM;
    final /* synthetic */ int tIT;
    final /* synthetic */ String tMB;
    final /* synthetic */ a tNo;
    final /* synthetic */ WepkgDownloadProcessTask tNp;
    final /* synthetic */ String tNs;
    final /* synthetic */ long tNt;
    final /* synthetic */ String tNu;
    final /* synthetic */ int tNv;
    final /* synthetic */ String val$downloadUrl;

    h$12(int i, String str, String str2, String str3, long j, String str4, String str5, int i2, WepkgDownloadProcessTask wepkgDownloadProcessTask, a aVar) {
        this.tIT = i;
        this.tMB = str;
        this.tNs = str2;
        this.val$downloadUrl = str3;
        this.tNt = j;
        this.tNu = str4;
        this.jkM = str5;
        this.tNv = i2;
        this.tNp = wepkgDownloadProcessTask;
        this.tNo = aVar;
    }

    public final void run() {
        WePkgDownloader.bVg().a(this.tIT, bh.ou(this.tMB), bh.ou(this.tNs), bh.ou(this.val$downloadUrl), this.tNt, bh.ou(this.tNu), bh.ou(this.jkM), this.tNv, new 1(this));
    }
}
