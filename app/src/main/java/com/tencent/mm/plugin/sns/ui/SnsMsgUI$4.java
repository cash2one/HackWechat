package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.p.d;

class SnsMsgUI$4 implements d {
    final /* synthetic */ SnsMsgUI rDE;

    SnsMsgUI$4(SnsMsgUI snsMsgUI) {
        this.rDE = snsMsgUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                SnsMsgUI.a(this.rDE, this.rDE.roN);
                return;
            case 1:
                SnsMsgUI.l(this.rDE);
                return;
            case 2:
                SnsMsgUI.a(this.rDE, false);
                return;
            default:
                return;
        }
    }
}
