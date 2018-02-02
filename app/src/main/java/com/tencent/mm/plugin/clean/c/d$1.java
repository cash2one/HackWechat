package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.sdk.platformtools.x;

class d$1 implements Runnable {
    d$1() {
    }

    public final void run() {
        if (d.bl() == 0) {
            x.i("MicroMsg.CleanLogic", "clean data");
            d.bR(0);
            d.m(null);
            return;
        }
        x.i("MicroMsg.CleanLogic", "clean data is using");
    }
}
