package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ExdeviceExpireUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ExdeviceExpireUI lUv;

    ExdeviceExpireUI$1(ExdeviceExpireUI exdeviceExpireUI) {
        this.lUv = exdeviceExpireUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lUv.finish();
        return false;
    }
}
