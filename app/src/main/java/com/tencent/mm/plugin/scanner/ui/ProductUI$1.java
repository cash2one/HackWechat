package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.scanner.a.c;
import com.tencent.mm.plugin.scanner.a.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class ProductUI$1 implements a$a {
    final /* synthetic */ ProductUI pWr;

    ProductUI$1(ProductUI productUI) {
        this.pWr = productUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (z) {
            x.i("MicroMsg.scanner.ProductUI", "getLocation suc");
            if (ProductUI.a(this.pWr) != null) {
                x.i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + f + ", lat=" + f2);
                ar.CG().a(new c(ProductUI.b(this.pWr), k.bC(ProductUI.a(this.pWr).qbc), ProductUI.c(this.pWr), ProductUI.d(this.pWr), (double) f, (double) f2), 0);
            }
            if (ProductUI.e(this.pWr) != null) {
                ProductUI.e(this.pWr).c(ProductUI.f(this.pWr));
            }
            if (!ProductUI.g(this.pWr)) {
                ProductUI.h(this.pWr);
                o.a(2011, f, f2, (int) d2);
            }
            return false;
        }
        x.w("MicroMsg.scanner.ProductUI", "getLocation fail");
        return false;
    }
}
