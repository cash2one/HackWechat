package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallRechargeUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallRechargeUI nLL;

    IPCallRechargeUI$5(IPCallRechargeUI iPCallRechargeUI) {
        this.nLL = iPCallRechargeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nLL.finish();
        return true;
    }
}
