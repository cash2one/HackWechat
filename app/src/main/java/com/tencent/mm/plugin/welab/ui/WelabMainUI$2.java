package com.tencent.mm.plugin.welab.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WelabMainUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ WelabMainUI tQc;

    WelabMainUI$2(WelabMainUI welabMainUI) {
        this.tQc = welabMainUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tQc.aWs();
        this.tQc.finish();
        return true;
    }
}
