package com.tencent.liteav;

class b$4 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ b c;

    b$4(b bVar, int i, int i2) {
        this.c = bVar;
        this.a = i;
        this.b = i2;
    }

    public void run() {
        if (b.a(this.c) != null) {
            b.a(this.c).getHolder().setFixedSize(this.a, this.b);
        }
    }
}
