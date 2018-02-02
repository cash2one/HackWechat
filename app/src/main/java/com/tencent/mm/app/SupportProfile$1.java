package com.tencent.mm.app;

import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aj.c;

class SupportProfile$1 implements c {
    final /* synthetic */ SupportProfile ffL;

    SupportProfile$1(SupportProfile supportProfile) {
        this.ffL = supportProfile;
    }

    public final void a(String str, Throwable th) {
        g.pQN.a(637, 0, 1, false);
        KVCommCrossProcessReceiver.boi();
    }
}
