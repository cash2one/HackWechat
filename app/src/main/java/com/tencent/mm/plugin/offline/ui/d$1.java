package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.k;

class d$1 implements Runnable {
    final /* synthetic */ boolean oXM;
    final /* synthetic */ d oXN;

    d$1(d dVar, boolean z) {
        this.oXN = dVar;
        this.oXM = z;
    }

    public final void run() {
        if (g.Dh().Cy()) {
            k.bgX();
            k.bha().hd(this.oXM);
        }
    }
}
