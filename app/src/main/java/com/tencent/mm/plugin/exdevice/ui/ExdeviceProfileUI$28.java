package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceProfileUI$28 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceProfileUI lVZ;

    ExdeviceProfileUI$28(ExdeviceProfileUI exdeviceProfileUI) {
        this.lVZ = exdeviceProfileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lVZ.finish();
        return false;
    }
}
