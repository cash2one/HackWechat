package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiPcUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiPcUI mIm;

    FreeWifiPcUI$1(FreeWifiPcUI freeWifiPcUI) {
        this.mIm = freeWifiPcUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        FreeWifiPcUI.a(this.mIm);
        return true;
    }
}
