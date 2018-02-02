package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiErrorUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiErrorUI mHh;

    FreeWifiErrorUI$1(FreeWifiErrorUI freeWifiErrorUI) {
        this.mHh = freeWifiErrorUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mHh.finish();
        return true;
    }
}
