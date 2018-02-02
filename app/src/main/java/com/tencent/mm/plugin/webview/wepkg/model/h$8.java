package com.tencent.mm.plugin.webview.wepkg.model;

class h$8 implements Runnable {
    final /* synthetic */ a tNo;
    final /* synthetic */ WepkgCrossProcessTask tNr;

    h$8(WepkgCrossProcessTask wepkgCrossProcessTask, a aVar) {
        this.tNr = wepkgCrossProcessTask;
        this.tNo = aVar;
    }

    public final void run() {
        this.tNr.Yr();
        if (this.tNo != null) {
            this.tNo.a(this.tNr);
        }
    }
}
