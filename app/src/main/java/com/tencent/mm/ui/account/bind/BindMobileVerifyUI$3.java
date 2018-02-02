package com.tencent.mm.ui.account.bind;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BindMobileVerifyUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ BindMobileVerifyUI xTG;

    BindMobileVerifyUI$3(BindMobileVerifyUI bindMobileVerifyUI) {
        this.xTG = bindMobileVerifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.xTG.finish();
        return true;
    }
}
