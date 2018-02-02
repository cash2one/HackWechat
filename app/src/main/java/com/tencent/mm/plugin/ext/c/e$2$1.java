package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.c.a.a;
import com.tencent.mm.plugin.ext.c.e.2;
import com.tencent.mm.sdk.platformtools.x;

class e$2$1 implements e {
    final /* synthetic */ 2 mbt;

    e$2$1(2 2) {
        this.mbt = 2;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ExtQrCodeHandler", "hy: check url done. errType: %d, errCode: %d, errMsg %s, scene: %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(((a) kVar).mbw == 0)});
        g.Di().gPJ.b(782, this);
        if (i == 0 && i2 == 0) {
            this.mbt.bX(Boolean.valueOf(r0));
        } else {
            this.mbt.bX(Boolean.valueOf(false));
        }
    }
}
