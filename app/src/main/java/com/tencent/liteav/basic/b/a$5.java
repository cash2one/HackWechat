package com.tencent.liteav.basic.b;

import com.tencent.liteav.basic.f.b;

class a$5 implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ a b;

    a$5(a aVar, b bVar) {
        this.b = aVar;
        this.a = bVar;
    }

    public void run() {
        a.m(this.b).add(this.a);
        a.f(this.b, (long) a.m(this.b).size());
        if (a.b(this.b) != null) {
            a.f(this.b, a.n(this.b) + ((long) a.b(this.b).n()));
        }
        a.g(this.b, this.a.h);
    }
}
