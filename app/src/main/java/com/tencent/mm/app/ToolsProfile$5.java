package com.tencent.mm.app;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView.b;

class ToolsProfile$5 implements b {
    final /* synthetic */ ToolsProfile ffM;

    ToolsProfile$5(ToolsProfile toolsProfile) {
        this.ffM = toolsProfile;
    }

    public final void tH() {
        x.i("MicroMsg.ToolsProfile", "onCoreInitFinished");
    }

    public final void tI() {
        x.i("MicroMsg.ToolsProfile", "onCoreInitFailed");
    }
}
