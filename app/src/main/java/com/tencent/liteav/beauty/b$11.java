package com.tencent.liteav.beauty;

class b$11 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ b b;

    b$11(b bVar, int i) {
        this.b = bVar;
        this.a = i;
    }

    public void run() {
        if (this.a > 0) {
            a.a().c();
        }
        if (b.e(this.b) != null && this.a >= 0) {
            b.e(this.b).d(this.a);
        }
    }
}
