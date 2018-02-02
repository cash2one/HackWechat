package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.q;
import com.tencent.mm.ui.chatting.b.l.1;

class l$1$2 implements Runnable {
    final /* synthetic */ q yAa;
    final /* synthetic */ 1 yzZ;

    l$1$2(1 1, q qVar) {
        this.yzZ = 1;
        this.yAa = qVar;
    }

    public final void run() {
        com.tencent.mm.ui.chatting.q.ad(this.yAa.fnx.fny, this.yAa.fnx.fnz, this.yAa.fnx.status);
    }
}
