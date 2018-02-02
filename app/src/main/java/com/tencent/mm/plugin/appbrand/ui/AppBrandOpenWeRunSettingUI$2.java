package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppBrandOpenWeRunSettingUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandOpenWeRunSettingUI jLg;

    AppBrandOpenWeRunSettingUI$2(AppBrandOpenWeRunSettingUI appBrandOpenWeRunSettingUI) {
        this.jLg = appBrandOpenWeRunSettingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.jLg.finish();
        return true;
    }
}
