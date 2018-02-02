package com.tencent.liteav;

class c$4 implements Runnable {
    final /* synthetic */ c a;

    c$4(c cVar) {
        this.a = cVar;
    }

    public void run() {
        if (c.b(this.a) != null) {
            c.b(this.a).b(true);
        }
        c.a(this.a, c.d(this.a).width, c.d(this.a).height);
    }
}
