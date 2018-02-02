package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.g;

class LuckyMoneyDetailUI$13 implements OnMenuItemClickListener {
    final /* synthetic */ LuckyMoneyDetailUI ohM;

    LuckyMoneyDetailUI$13(LuckyMoneyDetailUI luckyMoneyDetailUI) {
        this.ohM = luckyMoneyDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g.pQN.h(11701, new Object[]{Integer.valueOf(LuckyMoneyDetailUI.sf(LuckyMoneyDetailUI.m(this.ohM))), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
        Intent intent = new Intent();
        intent.setClass(this.ohM.mController.xIM, LuckyMoneyMyRecordUI.class);
        intent.putExtra("key_type", 2);
        this.ohM.startActivity(intent);
        return true;
    }
}
