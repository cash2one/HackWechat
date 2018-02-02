package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.g.a.qd;
import com.tencent.mm.plugin.notification.d.e.1;

class e$1$1 implements Runnable {
    final /* synthetic */ qd oUA;
    final /* synthetic */ 1 oUB;

    e$1$1(1 1, qd qdVar) {
        this.oUB = 1;
        this.oUA = qdVar;
    }

    public final void run() {
        qd qdVar = this.oUA;
        c cVar = new c();
        cVar.id = qdVar.fHM.fHL;
        this.oUB.oUz.bC(cVar);
    }
}
