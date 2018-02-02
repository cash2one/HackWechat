package com.tencent.liteav.beauty;

class b$10 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ b b;

    b$10(b bVar, int i) {
        this.b = bVar;
        this.a = i;
    }

    public void run() {
        b.f(this.b);
        b.a(this.b, b.c(this.b), b.d(this.b), this.a);
    }
}
