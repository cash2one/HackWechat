package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class LuckyMoneyF2FQRCodeUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

    LuckyMoneyF2FQRCodeUI$2(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        this.oar = luckyMoneyF2FQRCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.oar.finish();
        return true;
    }
}
