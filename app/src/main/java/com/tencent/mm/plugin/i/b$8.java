package com.tencent.mm.plugin.i;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;

class b$8 implements Runnable {
    final /* synthetic */ b kHR;

    b$8(b bVar) {
        this.kHR = bVar;
    }

    public final void run() {
        if (b.f(this.kHR) != null) {
            if (b.d(this.kHR) != null) {
                b.d(this.kHR);
                ag.K(b.f(this.kHR));
            }
            b.f(this.kHR).isStop = true;
            b.b(this.kHR, null);
            g.pQN.a(664, 2, 1, false);
        }
        if (b.h(this.kHR) != null) {
            b.h(this.kHR).isStop = true;
        }
    }
}
