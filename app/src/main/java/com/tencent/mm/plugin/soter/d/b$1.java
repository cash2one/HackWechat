package com.tencent.mm.plugin.soter.d;

import com.tencent.mm.plugin.soter.c.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.b;

class b$1 implements b<Boolean> {
    final /* synthetic */ long gyu;
    final /* synthetic */ e rSr;

    b$1(long j, e eVar) {
        this.gyu = j;
        this.rSr = eVar;
    }

    public final /* synthetic */ void aB(Object obj) {
        x.i("MicroMsg.SoterInitManager", "alvinluo onTerminate");
        x.i("MicroMsg.SoterInitManager", "alvinluo init takes %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - this.gyu)});
        if (this.rSr != null) {
            this.rSr.yc(0);
        }
    }
}
