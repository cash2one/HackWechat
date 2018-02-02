package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppBrandProfileUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandProfileUI jLy;

    AppBrandProfileUI$1(AppBrandProfileUI appBrandProfileUI) {
        this.jLy = appBrandProfileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jLy.onBackPressed();
        return true;
    }
}
