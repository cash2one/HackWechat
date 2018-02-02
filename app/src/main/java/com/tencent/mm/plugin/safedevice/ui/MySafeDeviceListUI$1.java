package com.tencent.mm.plugin.safedevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MySafeDeviceListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ MySafeDeviceListUI pRA;

    MySafeDeviceListUI$1(MySafeDeviceListUI mySafeDeviceListUI) {
        this.pRA = mySafeDeviceListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        MySafeDeviceListUI.a(this.pRA);
        return true;
    }
}
