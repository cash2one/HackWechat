package com.tencent.mm.app;

import com.tencent.mm.app.d.3;
import com.tencent.mm.kernel.b;

class d$3$1 implements Runnable {
    final /* synthetic */ int feU;
    final /* synthetic */ 3 feV;

    d$3$1(3 3, int i) {
        this.feV = 3;
        this.feU = i;
    }

    public final void run() {
        if (b.CE() != null) {
            b.CE().fW(this.feU);
        }
    }
}
