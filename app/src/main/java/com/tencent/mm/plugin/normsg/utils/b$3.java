package com.tencent.mm.plugin.normsg.utils;

class b$3 implements Runnable {
    final /* synthetic */ boolean[] oTh;
    final /* synthetic */ b oTi;
    final /* synthetic */ Throwable oTj;

    b$3(b bVar, Throwable th, boolean[] zArr) {
        this.oTi = bVar;
        this.oTj = th;
        this.oTh = zArr;
    }

    public final void run() {
        b.b(this.oTi, this.oTj);
        synchronized (this.oTh) {
            this.oTh[0] = true;
            this.oTh.notifyAll();
        }
    }
}
