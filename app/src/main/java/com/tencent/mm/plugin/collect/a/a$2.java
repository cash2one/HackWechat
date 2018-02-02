package com.tencent.mm.plugin.collect.a;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements e {
    final /* synthetic */ a lic;

    a$2(a aVar) {
        this.lic = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        g.Dk();
        g.Di().gPJ.b(304, (e) this);
        if (i != 0 || i2 != 0) {
            x.i("MicroMsg.SubCoreCollect", "set sound fail!");
        }
    }
}
