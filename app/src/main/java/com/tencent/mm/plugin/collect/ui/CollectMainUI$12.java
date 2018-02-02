package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CollectMainUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ CollectMainUI lnh;

    CollectMainUI$12(CollectMainUI collectMainUI) {
        this.lnh = collectMainUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lnh.finish();
        return true;
    }
}
