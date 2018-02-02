package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.a;

class AppBrandTBSDownloadProxyUI$a$1 implements Runnable {
    final /* synthetic */ int gSN;
    final /* synthetic */ a jMH;

    AppBrandTBSDownloadProxyUI$a$1(a aVar, int i) {
        this.jMH = aVar;
        this.gSN = i;
    }

    public final void run() {
        this.jMH.jME.tipDialog.setMessage(this.jMH.jME.mController.xIM.getString(j.iBA, new Object[]{String.valueOf(this.gSN)}));
    }
}
