package com.tencent.mm.app;

import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.aj.c;

class ToolsProfile$1 implements c {
    final /* synthetic */ ToolsProfile ffM;

    ToolsProfile$1(ToolsProfile toolsProfile) {
        this.ffM = toolsProfile;
    }

    public final void a(String str, Throwable th) {
        KVCommCrossProcessReceiver.boi();
    }
}
