package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandUI$5 implements Runnable {
    final /* synthetic */ AppBrandUI jMR;

    AppBrandUI$5(AppBrandUI appBrandUI) {
        this.jMR = appBrandUI;
    }

    public final void run() {
        try {
            KVCommCrossProcessReceiver.boi();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandUI", e, "sendKV", new Object[0]);
        }
    }
}
