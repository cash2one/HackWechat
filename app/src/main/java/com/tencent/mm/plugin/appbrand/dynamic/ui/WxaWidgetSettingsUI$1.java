package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WxaWidgetSettingsUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WxaWidgetSettingsUI iVk;

    WxaWidgetSettingsUI$1(WxaWidgetSettingsUI wxaWidgetSettingsUI) {
        this.iVk = wxaWidgetSettingsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iVk.finish();
        return false;
    }
}
