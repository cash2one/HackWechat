package com.tencent.liteav;

class c$3 implements Runnable {
    final /* synthetic */ c a;

    c$3(c cVar) {
        this.a = cVar;
    }

    public void run() {
        c.a(this.a, c.d(this.a).width, c.d(this.a).height);
    }
}
