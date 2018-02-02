package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiSuccWebViewUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiSuccWebViewUI mII;

    FreeWifiSuccWebViewUI$1(FreeWifiSuccWebViewUI freeWifiSuccWebViewUI) {
        this.mII = freeWifiSuccWebViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mII.finish();
        FreeWifiSuccWebViewUI.a(this.mII);
        return true;
    }
}
