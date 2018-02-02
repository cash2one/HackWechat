package com.tencent.mm.sandbox.updater;

import com.tencent.mm.sdk.platformtools.bh;

class AppUpdaterUI$11 implements Runnable {
    final /* synthetic */ String xck;
    final /* synthetic */ AppUpdaterUI xcq;

    AppUpdaterUI$11(AppUpdaterUI appUpdaterUI, String str) {
        this.xcq = appUpdaterUI;
        this.xck = str;
    }

    public final void run() {
        this.xcq.startActivity(bh.Vw(this.xck));
        AppUpdaterUI.f(this.xcq);
    }
}
