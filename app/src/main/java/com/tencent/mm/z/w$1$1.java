package com.tencent.mm.z;

import com.tencent.mm.z.w.1;
import com.tencent.mm.z.w.c;

class w$1$1 implements Runnable {
    final /* synthetic */ c hfD;
    final /* synthetic */ 1 hfE;

    w$1$1(1 1, c cVar) {
        this.hfE = 1;
        this.hfD = cVar;
    }

    public final void run() {
        if (this.hfE.hfC.hfB != null) {
            this.hfE.hfC.hfB.c(this.hfD.url, this.hfD.filename, this.hfD.pos);
        }
    }
}
