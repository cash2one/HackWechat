package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ProductFurtherInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ProductFurtherInfoUI pVB;

    ProductFurtherInfoUI$1(ProductFurtherInfoUI productFurtherInfoUI) {
        this.pVB = productFurtherInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pVB.finish();
        return false;
    }
}
