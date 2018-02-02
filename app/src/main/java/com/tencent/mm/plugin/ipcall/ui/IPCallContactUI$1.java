package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallContactUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallContactUI nIW;

    IPCallContactUI$1(IPCallContactUI iPCallContactUI) {
        this.nIW = iPCallContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nIW.finish();
        return true;
    }
}
