package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WxaWidgetPerformanceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WxaWidgetPerformanceUI iVh;

    WxaWidgetPerformanceUI$1(WxaWidgetPerformanceUI wxaWidgetPerformanceUI) {
        this.iVh = wxaWidgetPerformanceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iVh.finish();
        return false;
    }
}
