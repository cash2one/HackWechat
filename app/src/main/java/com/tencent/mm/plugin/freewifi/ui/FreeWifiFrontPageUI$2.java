package com.tencent.mm.plugin.freewifi.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FreeWifiFrontPageUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FreeWifiFrontPageUI mHw;

    FreeWifiFrontPageUI$2(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        this.mHw = freeWifiFrontPageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        FreeWifiFrontPageUI.a(this.mHw);
        return true;
    }
}
