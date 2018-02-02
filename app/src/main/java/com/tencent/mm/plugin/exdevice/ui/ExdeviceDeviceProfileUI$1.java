package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceDeviceProfileUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceDeviceProfileUI lUq;

    ExdeviceDeviceProfileUI$1(ExdeviceDeviceProfileUI exdeviceDeviceProfileUI) {
        this.lUq = exdeviceDeviceProfileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lUq.finish();
        return false;
    }
}
