package com.tencent.mm.plugin.appbrand.media;

class f$7 implements Runnable {
    final /* synthetic */ f jzQ;

    public f$7(f fVar) {
        this.jzQ = fVar;
    }

    public final void run() {
        synchronized (this.jzQ.jzF) {
            f.b(this.jzQ);
        }
    }
}
