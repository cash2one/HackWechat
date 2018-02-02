package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppBrandLauncherUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandLauncherUI jKR;

    AppBrandLauncherUI$3(AppBrandLauncherUI appBrandLauncherUI) {
        this.jKR = appBrandLauncherUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jKR.onBackPressed();
        return true;
    }
}
