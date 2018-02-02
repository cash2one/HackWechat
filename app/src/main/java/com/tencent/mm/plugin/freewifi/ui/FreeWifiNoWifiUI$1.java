package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiNoWifiUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiNoWifiUI mIi;

    FreeWifiNoWifiUI$1(FreeWifiNoWifiUI freeWifiNoWifiUI) {
        this.mIi = freeWifiNoWifiUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mIi.finish();
        return true;
    }
}
