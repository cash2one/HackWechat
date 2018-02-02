package com.tencent.liteav.beauty.b;

class u$1 implements Runnable {
    final /* synthetic */ u a;

    u$1(u uVar) {
        this.a = uVar;
    }

    public void run() {
        synchronized (u.a(this.a)) {
            u.b(this.a);
            u.a(this.a).notify();
        }
    }
}
