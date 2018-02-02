package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallShareCouponUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallShareCouponUI nMZ;

    IPCallShareCouponUI$8(IPCallShareCouponUI iPCallShareCouponUI) {
        this.nMZ = iPCallShareCouponUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nMZ.finish();
        return true;
    }
}
