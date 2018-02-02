package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppBrandNearbyEmptyUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandNearbyEmptyUI jLa;

    AppBrandNearbyEmptyUI$1(AppBrandNearbyEmptyUI appBrandNearbyEmptyUI) {
        this.jLa = appBrandNearbyEmptyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jLa.onBackPressed();
        return true;
    }
}
