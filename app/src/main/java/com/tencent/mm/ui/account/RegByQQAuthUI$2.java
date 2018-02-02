package com.tencent.mm.ui.account;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RegByQQAuthUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ RegByQQAuthUI xRG;

    RegByQQAuthUI$2(RegByQQAuthUI regByQQAuthUI) {
        this.xRG = regByQQAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.xRG.aWs();
        this.xRG.finish();
        return true;
    }
}
