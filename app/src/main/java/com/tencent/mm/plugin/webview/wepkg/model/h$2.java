package com.tencent.mm.plugin.webview.wepkg.model;

class h$2 implements Runnable {
    final /* synthetic */ a tNo = null;
    final /* synthetic */ WepkgCrossProcessTask tNq;

    h$2(WepkgCrossProcessTask wepkgCrossProcessTask, a aVar) {
        this.tNq = wepkgCrossProcessTask;
    }

    public final void run() {
        this.tNq.Yr();
        if (this.tNo != null) {
            this.tNo.a(this.tNq);
        }
    }
}
