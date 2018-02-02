package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WxaWidgetDebugUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WxaWidgetDebugUI iVc;

    WxaWidgetDebugUI$1(WxaWidgetDebugUI wxaWidgetDebugUI) {
        this.iVc = wxaWidgetDebugUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iVc.finish();
        return false;
    }
}
