package com.tencent.liteav;

class c$1 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ c d;

    c$1(c cVar, int i, int i2, int i3) {
        this.d = cVar;
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public void run() {
        if (!(this.a == 0 || this.b == 0)) {
            c.a(this.d).a = this.a;
            c.a(this.d).b = this.b;
            if (c.b(this.d) != null) {
                c.b(this.d).a(this.a, this.b);
            }
        }
        if (this.c != 0 && c.c(this.d) != null) {
            c.a(this.d).c = this.c;
            c.c(this.d).a(this.c);
        }
    }
}
