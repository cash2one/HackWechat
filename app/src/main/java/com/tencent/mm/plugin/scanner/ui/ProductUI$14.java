package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class ProductUI$14 implements OnClickListener {
    final /* synthetic */ ProductUI pWr;

    ProductUI$14(ProductUI productUI) {
        this.pWr = productUI;
    }

    public final void onClick(View view) {
        if (ProductUI.a(this.pWr) != null && !bh.ov(ProductUI.a(this.pWr).field_certificationurl)) {
            ProductUI.a(this.pWr, 10002, ProductUI.a(this.pWr).field_certificationurl);
            ProductUI.a(this.pWr, ProductUI.a(this.pWr).field_certificationurl);
        }
    }
}
