package com.tencent.mm.plugin.safedevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ModSafeDeviceNameUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ModSafeDeviceNameUI pRr;

    ModSafeDeviceNameUI$1(ModSafeDeviceNameUI modSafeDeviceNameUI) {
        this.pRr = modSafeDeviceNameUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pRr.finish();
        return true;
    }
}
