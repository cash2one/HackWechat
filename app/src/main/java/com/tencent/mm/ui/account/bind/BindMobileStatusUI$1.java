package com.tencent.mm.ui.account.bind;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BindMobileStatusUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BindMobileStatusUI xTk;

    BindMobileStatusUI$1(BindMobileStatusUI bindMobileStatusUI) {
        this.xTk = bindMobileStatusUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        BindMobileStatusUI.a(this.xTk);
        return false;
    }
}
