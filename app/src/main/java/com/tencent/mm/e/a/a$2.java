package com.tencent.mm.e.a;

import com.tencent.mm.compatible.b.f;
import com.tencent.mm.modelvoice.d$b;
import com.tencent.mm.sdk.platformtools.ag;

class a$2 implements d$b {
    final /* synthetic */ a fjH;

    a$2(a aVar) {
        this.fjH = aVar;
    }

    public final void onError() {
        f.xG().b(this.fjH);
        if (a.b(this.fjH)) {
            f.xG().xJ();
            a.c(this.fjH);
        }
        f.xG().setMode(0);
        if (a.d(this.fjH) != null) {
            ag.y(new 1(this));
        }
    }
}
