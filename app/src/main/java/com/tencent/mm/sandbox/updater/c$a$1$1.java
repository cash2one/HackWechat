package com.tencent.mm.sandbox.updater;

import com.tencent.mm.sandbox.updater.c.a.1;

class c$a$1$1 implements Runnable {
    final /* synthetic */ int xcQ;
    final /* synthetic */ 1 xcR;

    c$a$1$1(1 1, int i) {
        this.xcR = 1;
        this.xcQ = i;
    }

    public final void run() {
        if (this.xcR.xcP.bmD <= this.xcR.xcP.size) {
            this.xcR.xcP.xcx.cj(this.xcR.xcP.size, this.xcR.xcP.bmD);
        }
        this.xcR.xcP.xcx.fE((long) this.xcQ);
    }
}
