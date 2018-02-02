package com.tencent.mm.app;

import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aj.c;

class AppBrandProfile$1 implements c {
    final /* synthetic */ AppBrandProfile feI;

    AppBrandProfile$1(AppBrandProfile appBrandProfile) {
        this.feI = appBrandProfile;
    }

    public final void a(String str, Throwable th) {
        g.pQN.a(365, 3, 1, false);
        KVCommCrossProcessReceiver.boi();
    }
}
