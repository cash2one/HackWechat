package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CollectBillListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CollectBillListUI llF;

    CollectBillListUI$1(CollectBillListUI collectBillListUI) {
        this.llF = collectBillListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        CollectBillListUI.a(this.llF);
        return false;
    }
}
