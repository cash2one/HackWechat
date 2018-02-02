package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.mm.plugin.appbrand.game.c.d.c;

class d$b implements Runnable {
    private c iYA;
    private c iYD;

    private d$b() {
    }

    public final void run() {
        if (this.iYA != null && this.iYD != null) {
            this.iYD.j(this);
        }
    }
}
