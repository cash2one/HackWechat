package com.tencent.mm.plugin.welab.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WelabAppInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WelabAppInfoUI tPR;

    WelabAppInfoUI$1(WelabAppInfoUI welabAppInfoUI) {
        this.tPR = welabAppInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tPR.aWs();
        this.tPR.finish();
        return true;
    }
}
