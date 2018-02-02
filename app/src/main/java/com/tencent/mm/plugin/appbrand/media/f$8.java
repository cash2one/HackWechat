package com.tencent.mm.plugin.appbrand.media;

class f$8 implements Runnable {
    final /* synthetic */ f jzQ;

    public f$8(f fVar) {
        this.jzQ = fVar;
    }

    public final void run() {
        synchronized (this.jzQ.jzF) {
            this.jzQ.ais();
        }
    }
}
