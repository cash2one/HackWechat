package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI.2;
import com.tencent.mm.ui.base.p.d;

class LuckyMoneyMyRecordUI$2$2 implements d {
    final /* synthetic */ 2 oir;

    LuckyMoneyMyRecordUI$2$2(2 2) {
        this.oir = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                if (this.oir.oiq.mType != 2) {
                    this.oir.oiq.mType = 2;
                    LuckyMoneyMyRecordUI.b(this.oir.oiq);
                    this.oir.oiq.aXJ();
                    this.oir.oiq.aXA();
                    return;
                }
                return;
            case 2:
                if (this.oir.oiq.mType != 1) {
                    this.oir.oiq.mType = 1;
                    LuckyMoneyMyRecordUI.b(this.oir.oiq);
                    this.oir.oiq.aXJ();
                    this.oir.oiq.aXA();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
