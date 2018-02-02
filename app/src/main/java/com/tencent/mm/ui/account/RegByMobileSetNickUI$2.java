package com.tencent.mm.ui.account;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RegByMobileSetNickUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ RegByMobileSetNickUI xRe;

    RegByMobileSetNickUI$2(RegByMobileSetNickUI regByMobileSetNickUI) {
        this.xRe = regByMobileSetNickUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.xRe.aWs();
        this.xRe.finish();
        return true;
    }
}
