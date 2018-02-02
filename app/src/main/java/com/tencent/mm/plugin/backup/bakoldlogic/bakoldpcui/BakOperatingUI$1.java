package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BakOperatingUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BakOperatingUI krW;

    BakOperatingUI$1(BakOperatingUI bakOperatingUI) {
        this.krW = bakOperatingUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!BakOperatingUI.a(this.krW)) {
            BakOperatingUI.b(this.krW);
            BakOperatingUI.c(this.krW);
        }
        return true;
    }
}
