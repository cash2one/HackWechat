package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LuckyMoneyPrepareUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyPrepareUI ojC;

    LuckyMoneyPrepareUI$1(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        this.ojC = luckyMoneyPrepareUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ojC.finish();
        return true;
    }
}
