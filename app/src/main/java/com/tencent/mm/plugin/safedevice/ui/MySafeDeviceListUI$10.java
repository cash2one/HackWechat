package com.tencent.mm.plugin.safedevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MySafeDeviceListUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ MySafeDeviceListUI pRA;

    MySafeDeviceListUI$10(MySafeDeviceListUI mySafeDeviceListUI) {
        this.pRA = mySafeDeviceListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pRA.finish();
        return true;
    }
}
