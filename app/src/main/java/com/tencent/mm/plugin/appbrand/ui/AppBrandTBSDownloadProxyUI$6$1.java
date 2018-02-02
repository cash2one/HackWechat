package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI.6;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandTBSDownloadProxyUI$6$1 implements OnCancelListener {
    final /* synthetic */ 6 jMG;

    AppBrandTBSDownloadProxyUI$6$1(6 6) {
        this.jMG = 6;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancel loading download background");
        this.jMG.jME.setResult(2, new Intent());
        this.jMG.jME.finish();
    }
}
