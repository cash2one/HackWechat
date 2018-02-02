package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ProductPurchaseAreaUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ProductPurchaseAreaUI pVO;

    ProductPurchaseAreaUI$1(ProductPurchaseAreaUI productPurchaseAreaUI) {
        this.pVO = productPurchaseAreaUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pVO.finish();
        return false;
    }
}
