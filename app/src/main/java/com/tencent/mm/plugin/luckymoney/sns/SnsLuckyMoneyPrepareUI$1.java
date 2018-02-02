package com.tencent.mm.plugin.luckymoney.sns;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsLuckyMoneyPrepareUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SnsLuckyMoneyPrepareUI ofF;

    SnsLuckyMoneyPrepareUI$1(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        this.ofF = snsLuckyMoneyPrepareUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ofF.finish();
        return true;
    }
}
