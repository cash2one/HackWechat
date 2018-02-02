package com.tencent.mm.plugin.webview.wepkg.utils;

import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.a;

class d$1 implements Runnable {
    final /* synthetic */ WepkgCrossProcessTask tNf;
    final /* synthetic */ a tNo;

    d$1(WepkgCrossProcessTask wepkgCrossProcessTask, a aVar) {
        this.tNf = wepkgCrossProcessTask;
        this.tNo = aVar;
    }

    public final void run() {
        this.tNf.Yr();
        if (this.tNo != null) {
            this.tNo.a(this.tNf);
        }
    }
}
