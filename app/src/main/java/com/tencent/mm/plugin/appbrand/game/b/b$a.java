package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.magicbrush.a.d.a;
import com.tencent.mm.plugin.report.service.g;

final class b$a implements a {
    private int iYf;

    public b$a() {
        this.iYf = -1;
        this.iYf = 14883;
    }

    public final void c(Object... objArr) {
        if (this.iYf != -1) {
            g.pQN.h(this.iYf, objArr);
        }
    }
}
