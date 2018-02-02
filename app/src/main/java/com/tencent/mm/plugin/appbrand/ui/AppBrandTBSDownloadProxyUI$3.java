package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.sdk.f.a;

class AppBrandTBSDownloadProxyUI$3 implements a {
    final /* synthetic */ AppBrandTBSDownloadProxyUI jME;

    AppBrandTBSDownloadProxyUI$3(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        this.jME = appBrandTBSDownloadProxyUI;
    }

    public final void g(boolean z, int i) {
        if (!z || i < 36824) {
            x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download fail result %s version %d", Boolean.valueOf(z), Integer.valueOf(i));
            this.jME.setResult(0, new Intent());
            this.jME.finish();
            return;
        }
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download success result %s version %d", Boolean.valueOf(z), Integer.valueOf(i));
        ag.y(new 1(this));
    }
}
