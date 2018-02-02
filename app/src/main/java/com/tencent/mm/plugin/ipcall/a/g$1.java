package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.x;

class g$1 extends a {
    final /* synthetic */ g nCT;

    g$1(g gVar) {
        this.nCT = gVar;
    }

    public final void eq(int i) {
        int i2 = 0;
        x.i("MicroMsg.IPCallSvrLogic", "onNetworkChange, st: %d", new Object[]{Integer.valueOf(i)});
        if (i.aTy().nEJ) {
            f aTB = i.aTB();
            if (aTB.nCz == 4 || aTB.nCz == 5) {
                i2 = 1;
            }
            if (i2 != 0 && i == 4 && this.nCT.nCO != null) {
                this.nCT.nCO.a(this.nCT.nCP);
            }
        }
    }
}
