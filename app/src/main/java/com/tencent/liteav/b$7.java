package com.tencent.liteav;

class b$7 implements Runnable {
    final /* synthetic */ b a;

    b$7(b bVar) {
        this.a = bVar;
    }

    public void run() {
        if (b.c(this.a) != -1) {
            b.a(this.a, b.c(this.a));
            b.b(this.a, -1);
        }
        if (b.d(this.a) != -1) {
            b.b(this.a).l = b.d(this.a);
            b.e(this.a).d(b.b(this.a).l);
            b.c(this.a, -1);
        }
    }
}
