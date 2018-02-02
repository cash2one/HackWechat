package com.tencent.xweb.xwalk;

class g$2 implements Runnable {
    final /* synthetic */ g Atf;

    g$2(g gVar) {
        this.Atf = gVar;
    }

    public final void run() {
        if (this.Atf.Atd != null) {
            this.Atf.Atd.cleanup();
            this.Atf.Atd = null;
            this.Atf.AsP.getLooper().quit();
            this.Atf.AsP = null;
        }
    }
}
