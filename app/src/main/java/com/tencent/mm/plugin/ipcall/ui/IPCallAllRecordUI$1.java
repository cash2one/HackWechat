package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallAllRecordUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallAllRecordUI nIG;

    IPCallAllRecordUI$1(IPCallAllRecordUI iPCallAllRecordUI) {
        this.nIG = iPCallAllRecordUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nIG.finish();
        return true;
    }
}
