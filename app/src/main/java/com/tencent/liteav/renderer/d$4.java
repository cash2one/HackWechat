package com.tencent.liteav.renderer;

class d$4 implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ d b;

    d$4(d dVar, boolean z) {
        this.b = dVar;
        this.a = z;
    }

    public void run() {
        synchronized (d.c(this.b)) {
            this.b.a(this.a);
            d.c(this.b).notifyAll();
        }
    }
}
