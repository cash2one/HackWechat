package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallDialUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallDialUI nJK;

    IPCallDialUI$1(IPCallDialUI iPCallDialUI) {
        this.nJK = iPCallDialUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nJK.finish();
        return true;
    }
}
