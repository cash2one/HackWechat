package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceBindDeviceGuideUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceBindDeviceGuideUI lSn;

    ExdeviceBindDeviceGuideUI$1(ExdeviceBindDeviceGuideUI exdeviceBindDeviceGuideUI) {
        this.lSn = exdeviceBindDeviceGuideUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lSn.finish();
        return true;
    }
}
