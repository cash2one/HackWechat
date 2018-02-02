package com.tencent.liteav.screencapture;

class b$2 implements Runnable {
    final /* synthetic */ b a;

    b$2(b bVar) {
        this.a = bVar;
    }

    public void run() {
        synchronized (this.a) {
            if (b.b(this.a).size() == 0) {
                b.c(this.a);
            }
        }
    }
}
