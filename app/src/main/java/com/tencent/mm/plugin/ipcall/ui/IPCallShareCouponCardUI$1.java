package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class IPCallShareCouponCardUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallShareCouponCardUI nMs;

    IPCallShareCouponCardUI$1(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        this.nMs = iPCallShareCouponCardUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nMs.finish();
        return true;
    }
}
