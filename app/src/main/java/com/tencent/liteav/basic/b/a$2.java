package com.tencent.liteav.basic.b;

import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.util.TXCTimeUtil;

class a$2 implements Runnable {
    final /* synthetic */ a a;

    a$2(a aVar) {
        this.a = aVar;
    }

    public void run() {
        b a = a.a(this.a);
        if (!(a == null || a.b(this.a) == null)) {
            a.b(this.a).b(a);
        }
        long timeTick = TXCTimeUtil.getTimeTick();
        if (timeTick > a.c(this.a) + ((long) a.k())) {
            a.a(this.a, a.d(this.a) + this.a.c());
            a.e(this.a);
            long d = this.a.d();
            a.b(this.a, a.f(this.a) + d);
            a.g(this.a);
            if (a.h(this.a) > 0) {
                a.c(this.a, a.f(this.a) / a.h(this.a));
            }
            if (d > a.i(this.a)) {
                a.d(this.a, d);
            }
            a.e(this.a, timeTick);
        }
        if (a.j(this.a)) {
            a.k(this.a);
        }
    }
}
