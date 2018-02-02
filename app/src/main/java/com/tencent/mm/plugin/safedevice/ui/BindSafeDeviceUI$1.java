package com.tencent.mm.plugin.safedevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BindSafeDeviceUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BindSafeDeviceUI pRn;

    BindSafeDeviceUI$1(BindSafeDeviceUI bindSafeDeviceUI) {
        this.pRn = bindSafeDeviceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pRn.finish();
        return true;
    }
}
