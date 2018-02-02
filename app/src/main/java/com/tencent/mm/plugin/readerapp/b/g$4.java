package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class g$4 implements Runnable {
    final /* synthetic */ g pAH;

    g$4(g gVar) {
        this.pAH = gVar;
    }

    public final void run() {
        if (ar.Hj()) {
            ar.Hg();
            bh.g(c.Fi(), "ReaderApp_", 604800000);
        }
    }

    public final String toString() {
        return super.toString() + "|onAccountPostReset";
    }
}
