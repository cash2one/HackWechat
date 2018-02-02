package com.tencent.mm.plugin.sns.lucky.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsLuckyMoneyDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SnsLuckyMoneyDetailUI qSf;

    SnsLuckyMoneyDetailUI$2(SnsLuckyMoneyDetailUI snsLuckyMoneyDetailUI) {
        this.qSf = snsLuckyMoneyDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qSf.finish();
        return true;
    }
}
