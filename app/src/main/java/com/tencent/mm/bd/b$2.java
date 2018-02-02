package com.tencent.mm.bd;

import com.d.a.a.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements Runnable {
    final /* synthetic */ b hLN;

    b$2(b bVar) {
        this.hLN = bVar;
    }

    public final void run() {
        x.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
        a.xef.c(b.f(this.hLN));
        t.sp();
        t.finish();
        if (b.g(this.hLN) != null) {
            b.g(this.hLN).finish();
            b.a(this.hLN, null);
        }
        b.l(this.hLN);
        b.m(this.hLN);
        b.n(this.hLN);
        b.a(this.hLN, false);
    }
}
