package com.tencent.mm.plugin.voip_cs.b.a;

import java.util.TimerTask;

class b$7 extends TimerTask {
    final /* synthetic */ b sxB;

    b$7(b bVar) {
        this.sxB = bVar;
    }

    public final void run() {
        b.p(this.sxB).post(new 1(this));
    }
}
