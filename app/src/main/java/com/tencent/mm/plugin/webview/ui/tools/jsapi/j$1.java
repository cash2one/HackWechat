package com.tencent.mm.plugin.webview.ui.tools.jsapi;

class j$1 implements Runnable {
    final /* synthetic */ j tJT;

    j$1(j jVar) {
        this.tJT = jVar;
    }

    public final void run() {
        if (this.tJT.tJR != null && this.tJT.hpO != null) {
            this.tJT.nVX.a(this.tJT.tJP);
            this.tJT.hpO.c(this.tJT.tJR);
            this.tJT.tJR.a(false, 0.0f, 0.0f, 0, 0.0d, 0.0d, 0.0d);
        }
    }
}
