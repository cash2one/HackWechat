package com.tencent.mm.plugin.ac.a;

import com.tencent.mm.g.a.gw;
import com.tencent.mm.plugin.ac.a.c.a;

class c$4 implements Runnable {
    final /* synthetic */ a pvg;
    final /* synthetic */ gw pvi;

    c$4(a aVar, gw gwVar) {
        this.pvg = aVar;
        this.pvi = gwVar;
    }

    public final void run() {
        if (this.pvg != null && this.pvi != null && this.pvi.fxc != null) {
            if (this.pvi.fxc.ret == 1) {
                this.pvg.hs(true);
            } else if (this.pvi.fxc.ret == 2) {
                this.pvg.hs(false);
            }
        }
    }
}
