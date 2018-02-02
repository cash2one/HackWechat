package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallUserProfileUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallUserProfileUI nNH;

    IPCallUserProfileUI$1(IPCallUserProfileUI iPCallUserProfileUI) {
        this.nNH = iPCallUserProfileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nNH.finish();
        return true;
    }
}
