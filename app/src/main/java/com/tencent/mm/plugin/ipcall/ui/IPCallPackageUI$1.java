package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallPackageUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallPackageUI nLh;

    IPCallPackageUI$1(IPCallPackageUI iPCallPackageUI) {
        this.nLh = iPCallPackageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nLh.finish();
        return true;
    }
}
