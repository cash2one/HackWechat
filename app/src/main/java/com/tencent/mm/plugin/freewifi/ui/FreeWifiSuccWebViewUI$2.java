package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiSuccWebViewUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiSuccWebViewUI mII;

    FreeWifiSuccWebViewUI$2(FreeWifiSuccWebViewUI freeWifiSuccWebViewUI) {
        this.mII = freeWifiSuccWebViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mII.finish();
        FreeWifiSuccWebViewUI.a(this.mII);
        return true;
    }
}
