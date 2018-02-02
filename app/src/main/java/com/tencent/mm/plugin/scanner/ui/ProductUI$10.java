package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ProductUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ ProductUI pWr;

    ProductUI$10(ProductUI productUI) {
        this.pWr = productUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (ProductUI.c(this.pWr) == 4) {
            this.pWr.setResult(0);
        }
        this.pWr.finish();
        return true;
    }
}
