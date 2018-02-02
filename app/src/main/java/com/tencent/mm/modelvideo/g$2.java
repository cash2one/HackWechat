package com.tencent.mm.modelvideo;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ak.a;

class g$2 implements a {
    final /* synthetic */ g hUv;

    g$2(g gVar) {
        this.hUv = gVar;
    }

    public final boolean uF() {
        if (this.hUv.a(g.o(this.hUv), g.f(this.hUv)) == -1) {
            g.a(this.hUv, 0 - (g.getLine() + 10000));
            g.f(this.hUv).a(3, -1, "doScene failed", this.hUv);
        }
        return false;
    }
}
