package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiStateUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiStateUI mIt;

    FreeWifiStateUI$4(FreeWifiStateUI freeWifiStateUI) {
        this.mIt = freeWifiStateUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        FreeWifiStateUI.c(this.mIt);
        return true;
    }
}
