package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiActivateStateUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiActivateStateUI mGy;

    FreeWifiActivateStateUI$4(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        this.mGy = freeWifiActivateStateUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        FreeWifiActivateStateUI.c(this.mGy);
        return true;
    }
}
