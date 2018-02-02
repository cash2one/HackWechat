package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ProductUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ProductUI pWr;

    ProductUI$2(ProductUI productUI) {
        this.pWr = productUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ProductUI.l(this.pWr);
        return true;
    }
}
