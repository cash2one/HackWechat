package com.tencent.mm.plugin.i;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;

class b$5 implements Runnable {
    final /* synthetic */ b kHR;

    public b$5(b bVar) {
        this.kHR = bVar;
    }

    public final void run() {
        b.a(this.kHR, false);
        if (b.b(this.kHR) != null) {
            if (b.d(this.kHR) != null) {
                b.d(this.kHR);
                ag.K(b.b(this.kHR));
            }
            b.b(this.kHR).isStop = true;
            b.a(this.kHR, null);
            g.pQN.a(664, 8, 1, false);
        }
    }
}
