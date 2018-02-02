package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AAQueryListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AAQueryListUI iih;

    AAQueryListUI$1(AAQueryListUI aAQueryListUI) {
        this.iih = aAQueryListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iih.finish();
        return false;
    }
}
