package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.R;

class b$8 implements Runnable {
    final /* synthetic */ b sxB;

    b$8(b bVar) {
        this.sxB = bVar;
    }

    public final void run() {
        a bJa = a.bJa();
        if (bJa.snl != null) {
            bJa.snl.e(R.k.dAl, false, 0);
        }
    }
}
