package com.tencent.mm.bd;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c hLS;

    c$1(c cVar) {
        this.hLS = cVar;
    }

    public final boolean uF() {
        x.w("MicroMsg.SenseWhereHttpUtil", "it is time up, has no sense where response.");
        if (this.hLS.hLO != null) {
            g.Di().gPJ.c(this.hLS.hLO);
        }
        this.hLS.hLO = null;
        this.hLS.hLP = null;
        synchronized (this.hLS.lock) {
            this.hLS.lock.notifyAll();
        }
        return false;
    }
}
