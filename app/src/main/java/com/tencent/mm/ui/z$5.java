package com.tencent.mm.ui;

import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.t;

class z$5 implements Runnable {
    final /* synthetic */ int xGI;
    final /* synthetic */ z xLL;

    z$5(z zVar, int i) {
        this.xLL = zVar;
        this.xGI = i;
    }

    public final void run() {
        if (this.xLL.xLx != null) {
            d.b(this.xGI, "ChattingUI" + this.xLL.xLx.csL(), hashCode());
            if (this.xGI == 4) {
                d.f("ChattingUI" + this.xLL.xLx.csL(), this.xLL.xLz, t.Wo());
            }
        }
    }
}
