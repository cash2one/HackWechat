package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.g.a.js;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class ProductUI$5 extends c<js> {
    final /* synthetic */ ProductUI pWr;

    ProductUI$5(ProductUI productUI) {
        this.pWr = productUI;
        this.xen = js.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((js) bVar).fAz.action) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                if (this.pWr.ilB != null) {
                    ProductUI.o(this.pWr);
                    break;
                }
                break;
        }
        return false;
    }
}
