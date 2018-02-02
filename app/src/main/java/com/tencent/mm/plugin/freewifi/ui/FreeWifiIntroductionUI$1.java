package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiIntroductionUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiIntroductionUI mHN;

    FreeWifiIntroductionUI$1(FreeWifiIntroductionUI freeWifiIntroductionUI) {
        this.mHN = freeWifiIntroductionUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mHN.finish();
        return false;
    }
}
