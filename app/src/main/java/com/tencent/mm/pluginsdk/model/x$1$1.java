package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.pluginsdk.model.x.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.x5.sdk.d.a;

class x$1$1 implements a {
    final /* synthetic */ 1 vdZ;

    x$1$1(1 1) {
        this.vdZ = 1;
    }

    public final void kQ(boolean z) {
        x.i("MicroMsg.TBSHelper", "tbs preInit callback, %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            x.fd(this.vdZ.icE, this.vdZ.vdY);
        } else {
            x.access$000(this.vdZ.icE, this.vdZ.vdY);
        }
    }
}
