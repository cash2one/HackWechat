package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LuckyMoneyCanShareListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyCanShareListUI ohs;

    LuckyMoneyCanShareListUI$1(LuckyMoneyCanShareListUI luckyMoneyCanShareListUI) {
        this.ohs = luckyMoneyCanShareListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ohs.finish();
        return true;
    }
}
