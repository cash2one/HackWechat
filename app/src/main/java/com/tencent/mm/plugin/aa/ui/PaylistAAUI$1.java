package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class PaylistAAUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ PaylistAAUI ikp;

    PaylistAAUI$1(PaylistAAUI paylistAAUI) {
        this.ikp = paylistAAUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ikp.finish();
        return false;
    }
}
