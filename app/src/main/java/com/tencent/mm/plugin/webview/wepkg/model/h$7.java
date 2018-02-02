package com.tencent.mm.plugin.webview.wepkg.model;

class h$7 implements Runnable {
    final /* synthetic */ a tNo = null;
    final /* synthetic */ WepkgCrossProcessTask tNr;

    h$7(a aVar, WepkgCrossProcessTask wepkgCrossProcessTask) {
        this.tNr = wepkgCrossProcessTask;
    }

    public final void run() {
        if (this.tNo != null) {
            this.tNo.a(this.tNr);
        }
        this.tNr.afj();
    }
}
