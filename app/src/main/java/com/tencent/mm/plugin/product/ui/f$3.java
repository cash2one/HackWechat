package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.g.a.sz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class f$3 extends c<sz> {
    final /* synthetic */ f pfL;

    f$3(f fVar) {
        this.pfL = fVar;
        this.xen = sz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sz szVar = (sz) bVar;
        if (szVar instanceof sz) {
            if (szVar.fLs.result != -1) {
                x.i("MicroMsg.MallProductUI", "MallProduct pay result : cancel");
            } else if (!f.e(this.pfL)) {
                x.i("MicroMsg.MallProductUI", "MallProduct pay result : ok");
                f.f(this.pfL);
                f.g(this.pfL);
            }
            return true;
        }
        x.f("MicroMsg.MallProductUI", "mismatched event");
        return false;
    }
}
