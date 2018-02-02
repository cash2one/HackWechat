package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppBrand404PageUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrand404PageUI jKi;

    AppBrand404PageUI$2(AppBrand404PageUI appBrand404PageUI) {
        this.jKi = appBrand404PageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jKi.finish();
        return true;
    }
}
