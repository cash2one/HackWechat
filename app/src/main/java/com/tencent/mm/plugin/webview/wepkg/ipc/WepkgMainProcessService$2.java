package com.tencent.mm.plugin.webview.wepkg.ipc;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.plugin.webview.wepkg.ipc.a.a;

class WepkgMainProcessService$2 extends a {
    final /* synthetic */ WepkgMainProcessService tMs;

    WepkgMainProcessService$2(WepkgMainProcessService wepkgMainProcessService) {
        this.tMs = wepkgMainProcessService;
    }

    public final void p(Message message) {
        WepkgMainProcessService.a(this.tMs).send(message);
    }

    public final void t(Bundle bundle) {
        WepkgMainProcessService.ad(bundle).Yr();
    }
}
