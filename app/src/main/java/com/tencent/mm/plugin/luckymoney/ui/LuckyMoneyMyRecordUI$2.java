package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.g;

class LuckyMoneyMyRecordUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyMyRecordUI oiq;

    LuckyMoneyMyRecordUI$2(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        this.oiq = luckyMoneyMyRecordUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.oiq.mController.xIM, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = new 2(this);
        gVar.bUk();
        return false;
    }
}
