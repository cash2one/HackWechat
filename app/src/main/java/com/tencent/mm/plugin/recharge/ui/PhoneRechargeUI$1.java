package com.tencent.mm.plugin.recharge.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class PhoneRechargeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ PhoneRechargeUI pDm;

    PhoneRechargeUI$1(PhoneRechargeUI phoneRechargeUI) {
        this.pDm = phoneRechargeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pDm.aWs();
        this.pDm.finish();
        return true;
    }
}
