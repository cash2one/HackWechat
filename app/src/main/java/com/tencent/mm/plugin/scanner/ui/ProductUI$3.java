package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.plugin.scanner.util.n.a;

class ProductUI$3 implements Runnable {
    final /* synthetic */ ProductUI pWr;
    final /* synthetic */ a pWs;

    ProductUI$3(ProductUI productUI, a aVar) {
        this.pWr = productUI;
        this.pWs = aVar;
    }

    public final void run() {
        ProductUI.a(this.pWr, this.pWs);
        ProductUI.b(this.pWr, this.pWs);
    }
}
