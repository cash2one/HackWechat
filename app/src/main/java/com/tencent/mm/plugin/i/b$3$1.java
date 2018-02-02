package com.tencent.mm.plugin.i;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.b.3;
import com.tencent.mm.storage.w.a;

class b$3$1 implements Runnable {
    final /* synthetic */ 3 kHT;

    b$3$1(3 3) {
        this.kHT = 3;
    }

    public final void run() {
        g.Dj().CU().a(a.xwl, Long.valueOf(-1));
        g.Dj().CU().a(a.xwk, Long.valueOf(0));
        g.Dj().CU().lH(true);
        b.asG().asH().delete();
        b.d(this.kHT.kHR, false);
    }
}
