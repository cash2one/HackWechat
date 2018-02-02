package com.tencent.mm.plugin.webview.wepkg.model;

class h$6 implements Runnable {
    final /* synthetic */ a tNo = null;
    final /* synthetic */ WepkgCrossProcessTask tNr;

    h$6(WepkgCrossProcessTask wepkgCrossProcessTask, a aVar) {
        this.tNr = wepkgCrossProcessTask;
    }

    public final void run() {
        this.tNr.Yr();
        if (this.tNo != null) {
            this.tNo.a(this.tNr);
        }
    }
}
