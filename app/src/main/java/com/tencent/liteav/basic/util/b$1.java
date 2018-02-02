package com.tencent.liteav.basic.util;

class b$1 implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ boolean[] b;
    final /* synthetic */ b c;

    b$1(b bVar, Runnable runnable, boolean[] zArr) {
        this.c = bVar;
        this.a = runnable;
        this.b = zArr;
    }

    public void run() {
        this.a.run();
        this.b[0] = true;
        synchronized (b.a(this.c)) {
            b.a(this.c).notifyAll();
        }
    }
}
