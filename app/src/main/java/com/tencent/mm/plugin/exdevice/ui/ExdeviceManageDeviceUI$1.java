package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceManageDeviceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceManageDeviceUI lUN;

    ExdeviceManageDeviceUI$1(ExdeviceManageDeviceUI exdeviceManageDeviceUI) {
        this.lUN = exdeviceManageDeviceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lUN.finish();
        return true;
    }
}
