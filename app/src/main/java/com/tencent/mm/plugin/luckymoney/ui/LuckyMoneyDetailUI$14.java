package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LuckyMoneyDetailUI$14 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyDetailUI ohM;

    LuckyMoneyDetailUI$14(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        this.ohM = luckyMoneyDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ohM.finish();
        return true;
    }
}
