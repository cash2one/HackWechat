package com.tencent.mm.plugin.webview.wepkg.model;

class h$3 implements Runnable {
    final /* synthetic */ a tNo = null;
    final /* synthetic */ WepkgCrossProcessTask tNq;

    h$3(a aVar, WepkgCrossProcessTask wepkgCrossProcessTask) {
        this.tNq = wepkgCrossProcessTask;
    }

    public final void run() {
        if (this.tNo != null) {
            this.tNo.a(this.tNq);
        }
        this.tNq.afj();
    }
}
