package com.tencent.mm.plugin.appbrand.g.a;

import com.tencent.mm.plugin.appbrand.p.c;

class f$2 implements Runnable {
    final /* synthetic */ f jwq;

    f$2(f fVar) {
        this.jwq = fVar;
    }

    public final void run() {
        f.d(this.jwq).executeVoidScript(c.uy("bootstrap_j2v8.js"));
    }
}
