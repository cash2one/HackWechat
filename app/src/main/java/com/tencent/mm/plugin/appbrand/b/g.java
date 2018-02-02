package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.plugin.appbrand.report.d;

abstract class g extends d {
    private final h iHx;

    g(h hVar) {
        this.iHx = hVar;
    }

    public void enter() {
        super.enter();
        this.iHx.a(this);
    }
}
