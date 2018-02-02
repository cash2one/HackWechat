package com.tencent.liteav;

class c$2 implements Runnable {
    final /* synthetic */ c a;

    c$2(c cVar) {
        this.a = cVar;
    }

    public void run() {
        try {
            if (this.a.a != null && c.b(this.a) != null && c.e(this.a) != null) {
                this.a.a.a(c.b(this.a).e(), c.e(this.a), c.a(this.a).t, c.d(this.a).width, c.d(this.a).height);
            }
        } catch (Exception e) {
        }
    }
}
