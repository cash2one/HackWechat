package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.x.a;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandTBSDownloadProxyUI$7 implements OnClickListener {
    final /* synthetic */ AppBrandTBSDownloadProxyUI jME;

    AppBrandTBSDownloadProxyUI$7(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        this.jME = appBrandTBSDownloadProxyUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.a(366, 3, 1, false);
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "user cancel");
        a.kR(false);
        this.jME.setResult(2, new Intent());
        this.jME.finish();
    }
}
