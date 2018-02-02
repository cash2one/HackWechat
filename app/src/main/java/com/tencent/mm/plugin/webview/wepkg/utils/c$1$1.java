package com.tencent.mm.plugin.webview.wepkg.utils;

import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.webview.wepkg.model.i;
import com.tencent.mm.plugin.webview.wepkg.utils.c.1;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;

class c$1$1 implements Runnable {
    final /* synthetic */ 1 tOb;

    c$1$1(1 1) {
        this.tOb = 1;
    }

    public final void run() {
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = 2003;
        if (ac.cfw()) {
            wepkgCrossProcessTask.Yr();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        WepkgVersion wepkgVersion = wepkgCrossProcessTask.tMS;
        if (wepkgVersion != null && !bh.ov(wepkgVersion.tNm)) {
            i.bVl().aU(wepkgVersion.tNm, true);
        }
    }
}
