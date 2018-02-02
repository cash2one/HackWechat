package com.tencent.mm.plugin.recharge.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RechargeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RechargeUI pDQ;

    RechargeUI$1(RechargeUI rechargeUI) {
        this.pDQ = rechargeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pDQ.aWs();
        this.pDQ.finish();
        return true;
    }
}
