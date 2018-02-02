package com.tencent.mm.plugin.appbrand.canvas;

class d$2 implements Runnable {
    final /* synthetic */ d iKJ;

    d$2(d dVar) {
        this.iKJ = dVar;
    }

    public final void run() {
        boolean z = this.iKJ.iKC;
        this.iKJ.iKC = false;
        if (z && this.iKJ.iKw) {
            this.iKJ.iKA.abh();
        }
    }
}
