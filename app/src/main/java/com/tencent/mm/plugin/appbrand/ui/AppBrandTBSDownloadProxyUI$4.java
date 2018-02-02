package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;

class AppBrandTBSDownloadProxyUI$4 implements Runnable {
    final /* synthetic */ AppBrandTBSDownloadProxyUI jME;

    AppBrandTBSDownloadProxyUI$4(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        this.jME = appBrandTBSDownloadProxyUI;
    }

    public final void run() {
        AppBrandTBSDownloadProxyUI.akQ();
        this.jME.setResult(0, new Intent());
        this.jME.finish();
    }
}
