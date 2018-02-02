package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiNetCheckUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiNetCheckUI mIe;

    FreeWifiNetCheckUI$2(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        this.mIe = freeWifiNetCheckUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mIe.finish();
        return true;
    }
}
