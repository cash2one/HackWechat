package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.w;
import com.tencent.mm.plugin.appbrand.ui.AppBrandTBSDownloadProxyUI;
import com.tencent.mm.pluginsdk.model.x.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements Runnable {
    final /* synthetic */ b jyT;
    final /* synthetic */ Runnable jyU;

    b$2(b bVar, Runnable runnable) {
        this.jyT = bVar;
        this.jyU = runnable;
    }

    public final void run() {
        w 1 = new 1(this);
        AppBrandLaunchProxyUI appBrandLaunchProxyUI = (AppBrandLaunchProxyUI) this.jyT.getBaseContext();
        long Wp = bh.Wp();
        x.d("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check tbs download, cost = %d, cheTBSRet = %d", new Object[]{Long.valueOf(bh.Wp() - Wp), Integer.valueOf(a.bYx())});
        switch (a.bYx()) {
            case 0:
                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), onReady");
                1.onReady();
                return;
            case 1:
                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), goProxyUI");
                if (appBrandLaunchProxyUI == null || !appBrandLaunchProxyUI.ahM()) {
                    1.ahZ();
                    return;
                } else {
                    appBrandLaunchProxyUI.a(1, new Intent().setClass(appBrandLaunchProxyUI.getBaseContext(), AppBrandTBSDownloadProxyUI.class).putExtra("intent_extra_download_ignore_network_type", true), 1.fyV);
                    return;
                }
            case 2:
                x.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), dealCannotDownload");
                1.ahZ();
                return;
            default:
                return;
        }
    }
}
