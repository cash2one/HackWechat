package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.sdk.platformtools.x;

class b$6 implements Runnable {
    final /* synthetic */ b sxB;

    b$6(b bVar) {
        this.sxB = bVar;
    }

    public final void run() {
        x.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
        if (!b.j(this.sxB).isFinishing()) {
            b.k(this.sxB).setVisibility(8);
            b.l(this.sxB).setVisibility(8);
            b.m(this.sxB).setVisibility(8);
            b.n(this.sxB);
            b.o(this.sxB);
        }
    }
}
