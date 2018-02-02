package com.tencent.mm.sandbox.updater;

import com.tencent.mm.sdk.platformtools.bh;

class AppInstallerUI$3 implements Runnable {
    final /* synthetic */ AppInstallerUI xcj;
    final /* synthetic */ String xck;

    AppInstallerUI$3(AppInstallerUI appInstallerUI, String str) {
        this.xcj = appInstallerUI;
        this.xck = str;
    }

    public final void run() {
        this.xcj.startActivity(bh.Vw(this.xck));
        AppInstallerUI.d(this.xcj);
    }
}
