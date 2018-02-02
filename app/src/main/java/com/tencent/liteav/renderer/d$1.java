package com.tencent.liteav.renderer;

class d$1 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ d b;

    d$1(d dVar, int i) {
        this.b = dVar;
        this.a = i;
    }

    public void run() {
        d.a(this.b, this.a);
        if (d.a(this.b) <= 0) {
            d.a(this.b, 1);
        } else if (d.a(this.b) > 60) {
            d.a(this.b, 60);
        }
        d.a(this.b, 0);
        d.b(this.b, 0);
    }
}
