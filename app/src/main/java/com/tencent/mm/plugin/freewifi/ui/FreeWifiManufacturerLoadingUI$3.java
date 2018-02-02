package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiManufacturerLoadingUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiManufacturerLoadingUI mHX;

    FreeWifiManufacturerLoadingUI$3(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        this.mHX = freeWifiManufacturerLoadingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mHX.finish();
        return true;
    }
}
