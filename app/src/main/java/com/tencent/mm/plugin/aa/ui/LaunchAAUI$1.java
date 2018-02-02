package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LaunchAAUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ LaunchAAUI ijW;

    LaunchAAUI$1(LaunchAAUI launchAAUI) {
        this.ijW = launchAAUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ijW.finish();
        return false;
    }
}
