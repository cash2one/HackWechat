package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LuckyMoneyIndexUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyIndexUI ohQ;

    LuckyMoneyIndexUI$1(LuckyMoneyIndexUI luckyMoneyIndexUI) {
        this.ohQ = luckyMoneyIndexUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ohQ.finish();
        return true;
    }
}
