package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements e {
    final /* synthetic */ sq sDH;
    final /* synthetic */ String sDI;
    final /* synthetic */ j sDJ;

    j$1(j jVar, sq sqVar, String str) {
        this.sDJ = jVar;
        this.sDH = sqVar;
        this.sDI = str;
    }

    public final void a(int i, int i2, String str, k kVar) {
        g.Dk();
        g.Di().gPJ.b(1767, this);
        if (i == 0 && i2 == 0) {
            this.sDH.fKv.buffer = this.sDI;
            this.sDH.fKv.fKz.run();
            return;
        }
        x.i("MicroMsg.HandleWCPayWalletBufferListener", "check jsapi error: %s, %s", new Object[]{Integer.valueOf(i2), str});
        this.sDH.fKv.retCode = -1;
        this.sDH.fKv.fKz.run();
    }
}
